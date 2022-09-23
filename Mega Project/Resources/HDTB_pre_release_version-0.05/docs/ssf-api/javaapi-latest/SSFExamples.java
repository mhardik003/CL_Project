/*
 * SSFExamples.java
 *
 * Created on December 17, 2007, 6:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author expert
 */
import java.io.PrintStream;
import java.util.Enumeration;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
/*
 * import Sanchay packages and classes
 */
import sanchay.corpus.ssf.SSFProperties;
import sanchay.corpus.ssf.SSFSentence;
import sanchay.corpus.ssf.SSFStory;
import sanchay.corpus.ssf.features.FeatureAttribute;
import sanchay.corpus.ssf.features.impl.FeatureAttributeImpl;
import sanchay.corpus.ssf.features.FeatureStructure;
import sanchay.corpus.ssf.features.FeatureStructures;
import sanchay.corpus.ssf.features.FeatureValue;
import sanchay.corpus.ssf.features.impl.FSProperties;
import sanchay.corpus.ssf.features.impl.FeatureStructuresImpl;
import sanchay.corpus.ssf.features.impl.FeatureStructureImpl;
import sanchay.corpus.ssf.features.impl.*;
import sanchay.corpus.ssf.features.impl.FeatureValueImpl;
import sanchay.corpus.ssf.impl.SSFSentenceImpl;
import sanchay.corpus.ssf.impl.SSFStoryImpl;
import sanchay.corpus.ssf.tree.SSFNode;
public class SSFExamples {
    
    /** Creates a new instance of SSFExamples */
    public SSFExamples() {
    }
    public static void main(String args[]){
        SSFExamples sam = new SSFExamples();
        // Create a object of FSPropeties for featureStructure  properties
        FSProperties fsp = new FSProperties();
        // Create Object of SSFPropertes for SSF propertiese.
        SSFProperties ssfp = new SSFProperties();
        SSFProperties cmlp = new SSFProperties();
        SSFStory story = new SSFStoryImpl();
        //Create of Object of SSFSentence interface
        SSFSentence sentence = new SSFSentenceImpl();
        try {
            //Read FeatureStructure propertes files
//            fsp.read("/home/expert/arun/props/fs-mandatory-attribs.txt",
//                    "/home/expert/arun/props/fs-props.txt", "UTF-8"); //throws java.io.FileNotFoundException;
//            //Read SSF properties file.
//            ssfp.read("/home/expert/arun/props/ssf-props.txt", "UTF-8"); //throws java.io.FileNotFoundException;
//            cmlp.read("/home/expert/arun/props/cml-props.txt", "UTF-8"); //throws java.io.FileNotFoundException;
            fsp.read("/home/setu/javaapi/Sanchay/props/fs-mandatory-attribs.txt",
                    "/home/setu/javaapi/Sanchay/props/fs-props.txt", "UTF-8"); //throws java.io.FileNotFoundException;
            //Read SSF properties file.
            ssfp.read("/home/setu/javaapi/Sanchay/props/ssf-props.txt", "UTF-8"); //throws java.io.FileNotFoundException;
	    //Read CML Properties file	
            cmlp.read("/home/setu/javaapi/Sanchay/props/cml-props.txt", "UTF-8"); //throws java.io.FileNotFoundException;
            //Set properties files
            FeatureStructuresImpl.setFSProperties(fsp);
            SSFNode.setSSFProperties(ssfp);
            SSFNode.setCMLProperties(cmlp);
            
            //Read the input file which is valid SSF format.if it is not then it is use as RAW data
            story.readFile(args[0]);
          //  story.readFile("tokenizer.out");
            //story.readFile("in.txt");
            // story.readFile("check.wx");
            //   story.readFile("tt.txt");
            // story.readFile("D:\\Sanchay-0.2\\Sanchay\\token.tmp");
           //  story.readFile("prune.out");
            //      story.readFile("token.tmp");
            sam.linkStory(story);
            story.save("output.txt", "UTF-8");
            //  sentence.readFile("D:\\Sanchay-0.2\\Sanchay\\test.txt");
            //Read input file that is in SSF format and contain sentence level SSF
            //sentence.readFile("D:\\Sanchay-0.2\\Sanchay\\postagger.out");
            //  sentence.readFile("D:\\Sanchay-0.2\\Sanchay\\token.tmp");
            //story.readFile("/home/sanchay/Sanchay/LinkIn.txt"); //throws java.io.FileNotFoundException;
            //Call the linkSen function which do some processing on sentence
            //   sam.linkSen(sentence);
            // print the output in SSF format on Console
            //  sentence.print(System.out);
            story.print(System.out);
        }
        
        catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }
    
    
    public void linkStory(SSFStory story){
        System.out.println("linkStory called");
        //int count = story.countParagraph();
        int count = story.countSentences();
        System.out.println(count);
        for(int i=0;i<count;i++){
            SSFSentence sent = story.getSentence(i);
            int ccount = sent.getRoot().getChildCount();
            System.out.println("sent=============="+ccount);
            for(int j=0;j<ccount;j++){
                SSFNode node = sent.getRoot().getChild(j);
                String word = node.getLexData();
                System.out.println("Sentence node=="+word);
                System.out.println(node.getName());  // This show the third columns
                System.out.println(node.getId());   //give the id of opening id i.e first column
                System.out.println("Tree node before chuck===="+node.getLexData()); //give the Second Culumn value
                node.setName("test1"); //Add or modify third column of SSF
                System.out.println("total Child===="+node.getChildCount());
                if (node.getFeatureStructures() != null && node.getChildCount() == 0){
                    FeatureStructure fs = node.getFeatureStructures().getAltFSValue(0);
                    
                    FeatureAttribute fa = fs.getAttribute(1);
                    FeatureValue fv = fa.getAltValue(0);
                    System.out.println("values before chunked===="+fv.toString());
                    
                } else {
                    
                    
                    System.out.println("enter new feature structure");
                     String test = "<fs af='bahuwa,n,m,s,,0,,'>|<fs af='bahuwa,n,m,s,,0,,'>";
                   // String test = "<fs af='bahuwa,n,m,s,,0,,'>";
                    FeatureStructures fsi = new FeatureStructuresImpl();
                    FeatureStructure fstr = new FeatureStructureImpl();
                    try{
                        
                        // fsi.addAltFSValue(fstr);
                        //   fstr.readString(test);
                        //node.setFeatureStructures(fsi);
                        fsi.readString(test);
                        node.setFeatureStructures(fsi);
                        
                    } catch(Exception e){}
                    System.out.println("no FeatureStructure");
                }
		//This loop is work for chunked data
                for(int k=0;k<node.countChildren();k++){
                    SSFNode nodeChild = (SSFNode) node.getChildAt(k);
                    String wordLexChild = nodeChild.getLexData();   //give the Second coulum value in case of chunked data
                    System.out.println("Tree node after chuncked===="+wordLexChild);
                    nodeChild.setName("TAG"); // modify or add third column in case of chunked data
                    System.out.println("total Children===="+nodeChild.getChildCount());
                    if (nodeChild.getFeatureStructures() != null && nodeChild.getChildCount() == 0){
                        FeatureStructure fss = nodeChild.getFeatureStructures().getAltFSValue(0);
                        FeatureAttribute faa = fss.getAttribute(2);
                        
                        FeatureValue fvv =faa.getAltValue(0);
                        
                        System.out.println("values after chunked ===="+fvv.toString());
                        FeatureValue temp = new FeatureValueImpl();
                        temp.setValue("test");
                        fss.modifyAttributeValue(temp ,2,0);
                        
                    } else{
                        System.out.println("There is no FeatureStructure");
                        
                    }
                    
                    
                }
                
            }
            
        }
        
    }
}
