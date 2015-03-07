#include <string>
#include "GraphTable.h"
#include <iostream>
using namespace std;

//-------------------------------GRAPH TABLE----------------------------------------//
GraphTable::GraphTable(){
	numVert =0;
	numEdges=0;

	Vertex* temporary = new Vertex();
	Edge* reserveEdge = new Edge(temporary, '!');
	temporary->out = reserveEdge;
	std::vector<Edge*>* saving = new vector<Edge*>;
	saving->push_back(reserveEdge);
	saving->clear();
	saving->reserve(1);
	adjacencies = new std::vector< std::vector<Edge*>* >;
	vector <Edge*>* newColumn;
	adjacencies->push_back(newColumn);
	cout<< adjacencies->capacity() << endl;
	adjacencies->reserve(1);
	cout<< adjacencies->capacity() << endl;
	adjacencies->push_back(saving);
	adjacencies->clear();
	cout<< adjacencies->capacity() << endl;
}
/*
 * Connecting Edge vertF -----> vertT via weigh
 * adjacencies[v][e]
 */
void GraphTable::InsertEdgeByWeight(Vertex* vertF,Vertex* vertT, char weigh){
		Edge* tempEdge = new Edge(vertT,weigh);
		/*
		 * Need to figure out how to properly allocate the space in adjacencies.size()
		 * Test 4 works with initial ID 0 but not test 5 with ID 4
		 */
		 std::vector<Edge*>* temp_vec = new vector<Edge*>;
		 temp_vec->push_back(tempEdge);
			/*if vector at location doesnt exist, we will push a new vector of edges otherwise we
			 * will need to push the edge into the current vector
			 */
		 if(adjacencies->size()<=vertF->thisState.stateId){
			 adjacencies->resize(vertF->thisState.stateId+1);
			 adjacencies[vertF->thisState.stateId].push_back(temp_vec);
			 //adjacencies->at(vertF->thisState.stateId)->push_back(tempEdge);
			 //cout<<"adfasfdas"<<endl;
		 }else{
			 //adjacencies[vertF->thisState.stateId][0]->push_back(tempEdge);
			 adjacencies->at(vertF->thisState.stateId)->push_back(tempEdge);
		 }
		cout<< adjacencies->capacity() << endl;
		//cout<< adjacencies->max_size() << endl;



}

void GraphTable::PrintTable(){
	for(int i=0;i<adjacencies->size();i++){
			std::cout<< " The State ID  "<< i <<"  contains the following Nodes "<<std::endl;
			for(int j=0;j<adjacencies[i].size();j++){
				std::vector<Edge*>* temp_cont = new vector<Edge*>;
				temp_cont = adjacencies[i][j];
				 for (std::vector<Edge*>::iterator it = temp_cont->begin() ; it != temp_cont->end(); ++it){
					 Edge* tempEdging = *it;
					 std::cout << "The weight is: " << tempEdging->returnWeight()<<" and the ID is: "<<tempEdging->returnToVertex()->thisState.stateId<<"\n"<<endl;
				 }
				   std::cout << '\n';
				// std::cout<< "-->"<<temp_cont->
				//std::cout<< "-->"<<tempVert->thisState.stateId<<"[weight: "<<adjacencies[i][j]->returnWeight()<<"]"<<endl;
			}
	}
}

void GraphTable::Closure(){

//--adjacencies Has it all--
//		while(true){
//
//		}
}

void GraphTable::TravelMarker(){



}
