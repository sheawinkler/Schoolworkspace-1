/*
 * GraphTable.h
 *
 *  Created on: Feb 16, 2015
 *      Author: Deverick
 */
#ifndef GRAPHTABLE_H_
#define GRAPHTABLE_H_
#include <string>
#include <map>
#include <vector>
#include "Edge.h"
#include "Vertex.h"

class Edge;

//-------------------------------GRAPH TABLE----------------------------------------//
class GraphTable{

public:
	//Dont forget your copy constructor
	GraphTable();
	int numVert, numEdges;
    typedef std::pair<Vertex*,char> transitionPair;
	std::multimap<int*, transitionPair > adjacencies;

	typedef std::pair<int*, transitionPair > map_pair;

	void InsertEdgeByWeight(Vertex* vertF, Vertex* vertT, char A);
	void Closure();
	void TravelMarker();
	void PrintTable();

};



#endif /* GRAPHTABLE_H_ */
