/*
 * Edge.h
 *
 *  Created on: Feb 16, 2015
 *      Author: Deverick
 */
#ifndef EDGE_H_
#define EDGE_H_
#include <string>
#include <vector>
#include "Vertex.h"

class Vertex;

class Edge{
private:

public:
	//Should this be a pointer..When I change what i point to, is it doing what i want it to?
	char weight;
	Vertex* vertexTo;
	//Edge* dangling;
	//CONSTRUCTOR
	Edge(Vertex* vertT, char weight);
	//Copy Constructor
	Edge(const Edge& E);

	Edge& operator=(const Edge& T);

	//GETTER METHODS maybe a set
	Vertex* returnToVertex(){
		return vertexTo;
	}

	char returnWeight(){
		return weight;
	}
	void makeFinalFalse();
	void makeFinalTrue();
	void makeRootFalse();
	void makeRootTrue();

};

#endif /* EDGE_H_ */
