/*
 * testing.cpp
 *
 *  Created on: Feb 22, 2015
 *      Author: Deverick
 */

#include "gtest/gtest.h"
#include "InfixToPostfix.h"
#include "Vertex.h"
#include "RegDFA.h"


TEST(precedenceTest, allChars){
	InfixToPostfix test;
	EXPECT_TRUE(test.higherPrecedence('*','('));
	EXPECT_TRUE(test.higherPrecedence('*','.'));
	EXPECT_TRUE(test.higherPrecedence('.','('));
	EXPECT_TRUE(test.higherPrecedence('|','('));

}


TEST(concatTest, simpleCombo){
	InfixToPostfix test;
	EXPECT_EQ("a.b",test.addConcat("ab"));
	EXPECT_NE("ab",test.addConcat("a.b"));
	EXPECT_EQ("((a*.b)|(b.a))",test.addConcat("((a*b)|(ba))"));
}

TEST(convertToPostfix, simpleCombo){
	InfixToPostfix test;
	EXPECT_EQ("ab.",test.convertToPostfix("a.b"));
	EXPECT_EQ("ab|",test.convertToPostfix("a|b"));
	EXPECT_EQ("ab*.",test.convertToPostfix("a.b*"));
	EXPECT_EQ("ab.*",test.convertToPostfix("(a.b)*"));
	EXPECT_EQ("a*b*|",test.convertToPostfix("a*|b*"));
	EXPECT_EQ("ab*.",test.convertToPostfix("a.b*"));
	EXPECT_EQ("ab.ba.|",test.convertToPostfix("(a.b|b.a)"));
	EXPECT_EQ("a*b.ba.|",test.convertToPostfix("((a*.b)|(b.a))"));
}


TEST(testingVertexandEdge, simpleVertexCreate){
	Vertex vertexTest;
	vertexTest.thisState.stateId =5;
	Vertex vertexTest2;
	vertexTest2.thisState.finalState=true;
	vertexTest2.thisState.stateId =4;

	Edge edgeTest = Edge(vertexTest2,'c');
	vertexTest.out = &edgeTest;
	EXPECT_EQ('c',vertexTest.out->returnWeight());

	//ACCESSING EDGES STATE ID
	Vertex* val =vertexTest.out->returnToVertex();
	EXPECT_EQ(4,val->thisState.stateId);
	cout<<"HELLO value is "<<val->thisState.stateId <<endl;

//	GraphTable gTables;
//	gTables.InsertEdgeByWeight(vertexTest, vertexTest2, 'c');
//	gTables.PrintTable();

}



GTEST_API_ int main(int argc, char **argv) {

  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
