package org.leibnizcenter.xml.to.json;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.leibnizcenter.xml.NotImplemented;
import org.leibnizcenter.xml.TerseJson;
import org.leibnizcenter.xml.helpers.DomHelper;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Maarten on 19/11/2015.
 */
public class TestDocument {
    @Test
    public void test() throws IOException, SAXException, ParserConfigurationException, NotImplemented {
        Document doc = DomHelper.parse("<!-- This is a comment --><root><firstElement/><secondElement/></root>");

        Object[] terseDoc = (Object[]) new TerseJson().convert(doc);
        Assert.assertEquals(terseDoc.length, 2);
        Assert.assertEquals(terseDoc[0], (short) 9);

        Object[] children = (Object[]) terseDoc[1];
        Assert.assertEquals(children.length, 2);

        System.out.println(new Gson().toJson(terseDoc));
    }
}
