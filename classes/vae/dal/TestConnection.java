/*    */ package WEB-INF.classes.vae.dal;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import vae.dal.JdbcTools;
/*    */ 
/*    */ public class TestConnection {
/*    */   public static void main(String[] args) {
/* 11 */     Connection con = JdbcTools.getConnect();
/* 12 */     Statement stmt = null;
/* 13 */     ResultSet res = null;
/*    */     try {
/* 15 */       stmt = con.createStatement();
/* 16 */       res = stmt.executeQuery("SELECT * from UTILISATEURS");
/*    */       
/* 18 */       while (res.next()) {
/* 19 */         System.out.println(res.getString("rue"));
/*    */       }
/*    */     }
/* 22 */     catch (SQLException e) {
/*    */       
/* 24 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\dal\TestConnection.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */