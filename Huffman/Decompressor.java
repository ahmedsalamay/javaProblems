/*
 * Huffman
 * 
 * $Revision: 1.0 $ $Package huffman $Source: /Decompressor.java $ Autor:
 * Juniperus Guxx </info><info @guxx.de>
 * 
 * Lizenz: GPL
 */

 

import java.util.*;


public class Decompressor
{

        public Hashtable        htHuffTable;

        public void setHuffTable( Hashtable htHuffTable )
        {
                this.htHuffTable = htHuffTable;
        }

        public String Decompress( String strEncoded )
        {
                // fur das dekomprimieren muss das datenstrom-prafix
                // fortlaufend mit den eintragen der huffman-tabelle
                // verglichen werden, bis es passt dann wurde die reprasentation
                // gefunden
                String result = new String();
                while ( strEncoded.length() > 0 )
                {
                        String strBuffer = "";
                        int nPos = 1;
                        while ( !htHuffTable.containsKey( strBuffer ) )
                        {
                                strBuffer = strEncoded.substring( 0, nPos++ );
                                if ( htHuffTable.containsKey( strBuffer ) )
                                {
                                        strEncoded = strEncoded.substring( nPos - 1 );
                                        result += htHuffTable.get( strBuffer );
                                }
                        }
                }
                return result;
        }
}