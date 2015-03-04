#include <string>
#include <iostream>
#include "Edge.h"


using namespace std;

//class Vertex;

Edge::Edge(Vertex vertT, char weigh){
	weight = weigh;
	vertexTo=&vertT;
	dangling =NULL;

}
//Copy Constructor
Edge::Edge(const Edge &e){
	vertexTo = e.vertexTo;
	weight = e.weight;
	dangling =NULL;
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
