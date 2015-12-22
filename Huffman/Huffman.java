
 

import java.util.*;

import huffman.Compressor;
import huffman.Decompressor;


public class Huffman
{

        protected Hashtable     htHuffTable;

        public Huffman()
        {
        }

        public String Compress( String strText )
        {
                Compressor comp = new Compressor();
                String strCompressed = comp.Compress( strText );
                this.htHuffTable = comp.htHuffTable;
                return strCompressed;
        }

        public String Decompress( String strText )
        {
                Decompressor dec = new Decompressor();
                dec.setHuffTable( this.htHuffTable );
                return dec.Decompress( strText );
        }
}