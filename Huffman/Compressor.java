/*
 * Huffman
 * 
 * $Revision: 1.0 $ $Package huffman $Source: /Compressor.java $ Autor:
 * Juniperus Guxx </info><info @guxx.de>
 * 
 * Lizenz: GPL
 */

 

import java.util.*;


public class Compressor
{

        protected String        strString;                      // zu komprimierender String
        protected String        strCompressed;          // komprimierter String

        protected ArrayList     alNodes;                        // 

        public Hashtable        htHuffTable;
        public Hashtable        htReverseHuffTable;

        public Compressor()
        {
                this.alNodes = new ArrayList();
        }

        public String Compress( String strString )
        {
                this.strString = strString;
                // die relative Haufigkeit der Zeichen ermitteln
                this.CountCharacter();
                // nach Haufigkeit sortieren
                this.SortList();
                // den eigentlichen Algorithmus ausfuhren
                this.DoHuffman();
                // die Bit-Kombinationen ablesen
                this.createNodeList();
                // die Ubersetzung in die Bit-Reprasentation durchfuhren
                this.Translate();
                return this.strCompressed;
        }

        protected void DoHuffman()
        {
                // solange gruppieren und wieder neu sortieren
                // bis nur noch ein einziger Baum ubrig ist
                while ( alNodes.size() > 1 )
                {
                        this.Group();
                        this.SortList();
                }
        }

        protected void createNodeList()
        {
                this.strCompressed = "";

                this.htHuffTable = new Hashtable();
                this.htReverseHuffTable = new Hashtable();

                // Pfad bis Knotenende verfolgen
                Node node = ( Node ) alNodes.get( 0 );
                node.GetChilds( "", this.htHuffTable, this.htReverseHuffTable );
        }

        protected void Translate()
        {
                // die eigentliche Kompression (Ubersetzung) durchfuhren
                for ( int i = 0; i < this.strString.length(); i++ )
                {
                        this.strCompressed += htReverseHuffTable.get( Character.toString( this.strString.charAt( i ) ) );
                }
        }

        protected void Group()
        {
                // die beiden Knoten mit der kleinsten Menge an
                // Zeichen befinden sich in der sortierten Liste
                // an erster und zweiter Stelle
                Node nodeA = ( Node ) this.alNodes.get( 0 );
                Node nodeB = ( Node ) this.alNodes.get( 1 );

                // diese werden nun entfernt
                this.alNodes.remove( nodeA );
                this.alNodes.remove( nodeB );

                // und als zusammengefasster knoten wieder angefugt
                this.AddNode( new Node( nodeA, nodeB ) );
        }

        protected void SortList()
        {
                Collections.sort( alNodes, new NodeComparator() );
        }

        protected void CountCharacter()
        {
                // zahlen der Zeichen
                int[] chars = new int[ 255 ];

                // fur jedes Zeichen
                for ( int i = 0; i < this.strString.length(); i++ )
                {
                        int nChar = this.strString.charAt( i );
                        // zum aktuellen Zeichen die Menge um 1 erhohen
                        chars[ nChar ]++;
                }

                // fur alle Zeichen mit der Menge gro?er 0
                for ( int i = 0; i < 255; i++ )
                {
                        if ( chars[ i ] > 0 )
                        {
                                // einen Knoten hinzufugen mit Menge hinzufugen
                                this.AddNode( new Node( Character.toString( ( char ) i ), chars[ i ] ) );
                        }
                }
        }

        protected void AddNode( Node node )
        {
                this.alNodes.add( node );
        }
}