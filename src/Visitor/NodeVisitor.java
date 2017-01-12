package Visitor;

import java.util.Iterator;
import java.io.*;

/**
 * Created by a on 12/01/17.
 */
public class NodeVisitor implements Visitor {

    public String content;
    @Override
    public String visit(VisitableNode node) {

       this.content = String.format("<%s>",node.data());
       Iterator<VisitableNode> childs = node.subtrees().iterator();
       VisitableNode currentNode;
       while(childs.hasNext()) {
              if(!(currentNode = childs.next()).isLeaf())
           this.content += currentNode.accept(this);
              else{
                  if(currentNode.data().equals("integer") || currentNode.data().equals("boolean"))
                      this.content += String.format("<%s/>",currentNode.data());
                  else
                  this.content += String.format("%s",currentNode.data());
              }
       }
       this.content +=String.format("</%s>",node.data());

            saveFileXML(content);
        return this.content;
    }

    public void saveFileXML(String content){
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("file_XML_Output.xml"), "utf-8"));
            writer.write(content);
            writer.close();
        } catch (IOException ex) {
            // report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }


}
