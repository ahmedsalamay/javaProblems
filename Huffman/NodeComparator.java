/*
 * Huffman
 * 
 * $Revision: 1.0 $ $Package huffman $Source: /NodeComparator.java $ Autor:
 * Juniperus Guxx </info><info @guxx.de>
 * 
 * Lizenz: GPL
 */

 

import java.util.Comparator;


public class NodeComparator implements Comparator
{

        public int compare( Object o1, Object o2 )
        {
                Node nodeA = ( Node ) o1;
                Node nodeB = ( Node ) o2;
                if ( nodeA.nCount > nodeB.nCount )
                        return 1;
                if ( nodeA.nCount < nodeB.nCount )
                        return -1;
                return 0;
        }
}