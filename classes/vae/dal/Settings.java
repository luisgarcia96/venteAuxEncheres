/*    */ package WEB-INF.classes.vae.dal;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Settings
/*    */ {
/* 10 */   private static Properties properties = new Properties(); static {
/*    */     try {
/* 12 */       properties.load(vae.dal.Settings.class.getResourceAsStream("properties.properties"));
/* 13 */     } catch (IOException e) {
/*    */       
/* 15 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String getProperties(String key) {
/* 20 */     return properties.getProperty(key);
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\dal\Settings.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */