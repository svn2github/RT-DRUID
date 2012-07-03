package com.eu.evidence.rtdruid.test.modules.oil.xtext.validation;

import com.eu.evidence.rtdruid.test.modules.oil.xtext.OilInjectorProvider;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.PackageProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(XtextRunner2.class)
@InjectWith(OilInjectorProvider.class)
public class DefaultTypesTests extends XtextTest {
  private static String path = new Function0<String>() {
    public String apply() {
      String _computeBundleClassPath = PackageProvider.DEFAULT.computeBundleClassPath(com.eu.evidence.rtdruid.test.modules.oil.xtext.validation.DefaultTypesTests.class);
      return _computeBundleClassPath;
    }
  }.apply();
  
  public DefaultTypesTests() {
    super(DefaultTypesTests.path);
  }
  
  @Test
  public void complexTest() {
      this.suppressSerialization();
      this.testFile("complexDefaultImpl001.oil");
  }
}
