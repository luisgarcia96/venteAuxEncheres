/*    */ package WEB-INF.classes.vae.dal;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import javax.naming.Context;
/*    */ import javax.naming.InitialContext;
/*    */ import javax.naming.NamingException;
/*    */ import javax.sql.DataSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ConnectionProvider
/*    */ {
/*    */   private static DataSource dataSource;
/*    */   
/*    */   static {
/*    */     try {
/* 18 */       Context context = new InitialContext();
/* 19 */       dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/pool_cnx");
/*    */     }
/* 21 */     catch (NamingException e) {
/* 22 */       e.printStackTrace();
/* 23 */       throw new RuntimeException("!!! Impossible d'acceder à la base de donnée !!!");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Connection getConnection() throws SQLException {
/* 35 */     return dataSource.getConnection();
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\dal\ConnectionProvider.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */