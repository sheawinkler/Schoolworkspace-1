#include <string>
#include "Vertex.h"
#include <iostream>
using namespace std;
Vertex::Vertex(void){

	out = NULL;
	out2 = NULL;
}
//Copy Constructor
Vertex::Vertex(const Vertex &T){
	thisState = T.thisState;
	out = T.out;
	out2 = T.out;
}

Vertex& Vertex::operator=(const Vertex& S){
	thisState = S.thisState;
	out = S.out;
	out2 = S.out;
	return *this;
}


Vertex::~Vertex() {
	// TODO Auto-generated destructor stub

}

