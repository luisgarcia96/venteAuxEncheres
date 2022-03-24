/*    */ package WEB-INF.classes.vae.ihm;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ 
/*    */ public class PropertiesReader
/*    */ {
/*  9 */   private static vae.ihm.PropertiesReader propr = new vae.ihm.PropertiesReader();
/* 10 */   private Properties prop = new Properties();
/* 11 */   private InputStream input = null;
/*    */   
/*    */   private PropertiesReader() {
/*    */     try {
/* 15 */       this.input = getClass().getClassLoader().getResourceAsStream("configuration.properties");
/* 16 */       this.prop.load(this.input);
/* 17 */     } catch (IOException ex) {
/* 18 */       ex.printStackTrace();
/*    */     } finally {
/* 20 */       if (this.input != null) {
/*    */         try {
/* 22 */           this.input.close();
/* 23 */         } catch (IOException e) {
/* 24 */           e.printStackTrace();
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public static vae.ihm.PropertiesReader getInstance() {
/* 31 */     return propr;
/*    */   }
/*    */   
/*    */   public String getValue(String key) {
/* 35 */     return this.prop.getProperty(key);
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\ihm\PropertiesReader.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */