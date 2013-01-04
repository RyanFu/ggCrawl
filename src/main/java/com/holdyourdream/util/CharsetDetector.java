package com.holdyourdream.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;
import org.mozilla.intl.chardet.nsPSMDetector;

public class CharsetDetector
{

    private boolean found = false;
    private String result;
    private int lang;

    public String[] detectChineseCharset(InputStream in) throws IOException
    {
        lang = nsPSMDetector.CHINESE;
        String[] prob;
        // Initalize the nsDetector() ;
        nsDetector det = new nsDetector(lang);
        // Set an observer...
        // The Notify() will be called when a matching charset is found.

        det.Init(new nsICharsetDetectionObserver()
        {

            public void Notify(String charset)
            {
                found = true;
                result = charset;
            }
        });
        BufferedInputStream imp = new BufferedInputStream(in);
        byte[] buf = new byte[1024];
        int len;
        boolean isAscii = true;
        while ((len = imp.read(buf, 0, buf.length)) != -1)
        {
            // Check if the stream is only ascii.
            if (isAscii)
                isAscii = det.isAscii(buf, len);
            // DoIt if non-ascii and not done yet.
            if (!isAscii)
            {
                if (det.DoIt(buf, len, false))
                    break;
            }
        }
        imp.close();
        in.close();
        det.DataEnd();
        if (isAscii)
        {
            found = true;
            prob = new String[]
                    {
                        "ASCII"
                    };
        } else if (found)
        {
            prob = new String[]
                    {
                        result
                    };
        } else
        {
            prob = det.getProbableCharsets();
        }
        return prob;
    }

    public String[] detectAllCharset(InputStream in) throws IOException
    {
        try
        {
            lang = nsPSMDetector.ALL;
            return detectChineseCharset(in);
        } catch (IOException e)
        {
            throw e;
        }
    }
    
    
    public static void printCharArray(String inStr) { 
        char[] myBuffer = inStr.toCharArray(); 

        //list each Charactor in byte value, short value, and UnicodeBlock Mapping 
        for (int i = 0; i < inStr.length(); i++) { 
            byte b = (byte) myBuffer[i]; 
            short s = (short) myBuffer[i]; 
            String hexB = Integer.toHexString(b).toUpperCase(); 
            String hexS = Integer.toHexString(s).toUpperCase(); 
            StringBuffer sb = new StringBuffer(); 

            //print char 
            sb.append("char["); 
            sb.append(i); 
            sb.append("]='"); 
            sb.append(myBuffer[i]); 
            sb.append("'\t"); 

            //byte value 
            sb.append("byte="); 
            sb.append(b); 
            sb.append(" \\u"); 
            sb.append(hexB); 
            sb.append('\t'); 

            //short value 
            sb.append("short="); 
            sb.append(s); 
            sb.append(" \\u"); 
            sb.append(hexS); 
            sb.append('\t'); 

            //Unicode Block 
            sb.append(Character.UnicodeBlock.of(myBuffer[i])); 

            System.out.println(sb.toString()); 
        } 

        System.out.println(); 
    } 
}