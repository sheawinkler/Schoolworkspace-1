#include <string>
#include <iostream>
#include "Edge.h"
using namespace std;

Edge::Edge(Vertex* vertT, char weigh){
	weight = weigh;
	vertexTo=vertT;
	//dangling =NULL;

}
//Copy Constructor
Edge::Edge(const Edge &E){
	vertexTo = E.vertexTo;
	weight = E.weight;
	//dangling =NULL;
}


void Edge::makeFinalFalse(){
	vertexTo->thisState.finalState=false;
}
void Edge::makeFinalTrue(){
	vertexTo->thisState.finalState=true;
}

void Edge::makeRootFalse(){
	vertexTo->thisState.rootState=false;
}
void Edge::makeRootTrue(){
	vertexTo->thisState.rootState=true;
}

Edge& Edge::operator=(const Edge& T){
	vertexTo = T.vertexTo;
	weight = T.weight;
	//dangling =T.dangling;
	return *this;
}
