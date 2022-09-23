#include "c_api/c_api_v3.h"

int main(int argc,char *argv[])
{
	/* Please keep all the files that you are using have this as the basic code */
	
	circle *tree;   // create the doc object
	tree=create_circle(NULL); // initialize the datastructure
	read_ssf_from_file(tree,argv[1]);  // read from the file into tree
	int sentence=sentences(tree);
	node * temp[sentence];   // create the node object to store all the nodes retuned
	int count=0,i;  // count to count the # of sentences or nodes returned

	count=traverse_tree(tree,temp,count); // function which returns all the sentence nodes into temp
	
	/* basic code ends here */
	
	for(i=0;i<count;i++)    // loop on the nodes returned and apply the desired function like pos tagger
				// replace with your desired function
	//print_tree(temp[i]);   // print the datastructure at STDOUT
	
	print_tree_to_file(tree,"read_print_ssf.txt"); // print the datastructure into file
 	
	/* here u can manipulate sentences using their ids  
	 * for first sentence and second child use node *child= get_nth_child(temp[0], 2);
	 * second sentence and second child use node *child= get_nth_child(temp[1], 2); 
	 * second sentence and third child use node *child= get_nth_child(temp[1], 3); etcc
	 */
 
	//node *child= get_nth_child(temp[0], 1); 
	
	/*Checking add_attr_val-----Working*/
	//add_attr_val(child->OR, "iiit", "'hyderabad'");
	//printf("%s\n", make_or_node_to_string(child->OR)) ;
	//printf("Checked add_attr_val\n\n");
	//printf(" After changes\n");
	//print_tree(temp[0]);
	//print_tree_to_file(tree,"read_print.txt"); // print the datastructure into file

}
