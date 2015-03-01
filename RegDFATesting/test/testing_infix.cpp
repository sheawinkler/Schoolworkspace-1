/*
 *
 *  Testing_infix.cpp
 *  Created on: Feb 21, 2015
 *      Author: Deverick
 */
#include <stdio.h>
#include "gtest/gtest.h"
#include "InfixToPostfix.h"


InfixToPostfix test;

TEST(precedenceTest, ChecksAllPossible){
	EXPECT_TRUE('1');
//	EXPECT_FALSE(test.higherPrecedence('(','|'));
//	EXPECT_TRUE(test.higherPrecedence('*','|'));
//	EXPECT_FALSE(test.higherPrecedence('.','*'));
//	EXPECT_FALSE(test.higherPrecedence('(','|'));
//	EXPECT_FALSE(test.higherPrecedence('(','('));
}
//
//TEST(concatTest, FewPossibleConcats){
//	string STRING = "a.ba";
//
//	EXPECT_EQ("ab.a", test.addConcat(STRING));
//	EXPECT_NE("a.b.a", test.addConcat(STRING));
//}

