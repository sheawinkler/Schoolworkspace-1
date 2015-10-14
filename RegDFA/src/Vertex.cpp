#include <string>
#include "Vertex.h"
#include <iostream>
using namespace std;
Vertex::Vertex(void){
	out = NULL;
	out2 = NULL;
	//Need to set values to null here
	std::vector<Vertex > neighbors;
}
//Copy Constructor
Vertex::Vertex(const Vertex &T){
	thisState = T.thisState;
	out = T.out;
	out2 = T.out2;
	//Need to set values to null here
	std::vector<Vertex > neighbors;
}

Vertex& Vertex::operator=(const Vertex& S){
	thisState = S.thisState;
	out = S.out;
	out2 = S.out2;
	return *this;
}


Vertex::~Vertex() {
	// TODO Auto-generated destructor stub

}

