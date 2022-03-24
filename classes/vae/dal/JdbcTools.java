/*    */ package WEB-INF.classes.vae.dal;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ import vae.dal.Settings;
/*    */ 
/*    */ public class JdbcTools {
/*  8 */   private static Connection con = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Connection getConnect() {
/*    */     try {
/*    */       try {
/* 17 */         Class.forName(Settings.getProperties("driverjdbc"));
/* 18 */       } catch (ClassNotFoundException e) {
/*    */         
/* 20 */         e.printStackTrace();
/*    */       } 
/* 22 */       con = DriverManager.getConnection(Settings.getProperties("url"), Settings.getProperties("user"), Settings.getProperties("password"));
/* 23 */     } catch (SQLException e) {
/* 24 */       e.printStackTrace();
/*    */     } 
/*    */     
/* 27 */     return con;
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\dal\JdbcTools.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */