/*
 * Huffman
 * 
 * $Revision: 1.0 $ $Package huffman $Source: /Node.java $ Autor: Juniperus Guxx
 * </info><info @guxx.de>
 * 
 * Lizenz: GPL
 */

 

import java.util.*;


public class Node
{

        public String   strKey; // der Schlussel beinhaltet auch die
                                                                // zusammengesetzten Knoten
        public int              nCount; // Menge der Zeichen dieses Knoten
        public boolean  bHasChilds; // gibt an, ob der Knoten Kinder hat

        protected Node  nodeChildA; // Maximal 2 Kinderknoten
        protected Node  nodeChildB;

        public Node( String key, int count )
        {
                this.strKey = key;
                this.nCount = count;
                this.bHasChilds = false;
        }

        public Node( Node nodeA, Node nodeB )
        {
                this.strKey = nodeA.strKey + "," + nodeB.strKey; // Schreibweise fur den
                                                                                                                        // Key ist key1,key2
                this.nCount = nodeA.nCount + nodeB.nCount; // Menge addiert sich
                this.nodeChildA = nodeA;
                this.nodeChildB = nodeB;
                this.bHasChilds = true; // Flag setzen
        }

        public void GetChilds( String stream, Hashtable htHuffTable, Hashtable htReverseHuffTable )
        {
                // Wenn das Ende eines Pfades gefunden wurde, wird das Ergebnis in die
                // Listen
                // eingetragen
                // um einfacheren Zugriff auf die Listen zu erhalten wird zusatzlich
                // eine inverse Liste gefullt

                if ( this.bHasChilds ) // nur, wenn es Kind-Knoten gibt.
                {
                        this.nodeChildA.GetChilds( stream + "0", htHuffTable, htReverseHuffTable ); // NodeA
                                                                                                                                                                                // bekommt
                                                                                                                                                                                // als
                                                                                                                                                                                // Richtung
                                                                                                                                                                                // im
                                                                                                                                                                                // Baum
                                                                                                                                                                                // 0
                                                                                                                                                                                // zugewiesen
                        this.nodeChildB.GetChilds( stream + "1", htHuffTable, htReverseHuffTable ); // NodeB
                                                                                                                                                                                // die
                                                                                                                                                                                // 1
                }
                else
                {
                        htHuffTable.put( stream, this.strKey ); // Wenn das ende erreicht
                                                                                                        // ist, dann werden die
                                                                                                        // Daten in die
                        htReverseHuffTable.put( this.strKey, stream ); // beiden Tabellen
                                                                                                                        // eingetragen
                }
        }
}