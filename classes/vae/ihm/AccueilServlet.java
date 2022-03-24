/*    */ package WEB-INF.classes.vae.ihm;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import vae.bll.ArticleVenduManager;
/*    */ import vae.bo.Categorie;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebServlet({"/accueil"})
/*    */ public class AccueilServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 38 */     ArticleVenduManager articleVenduManager = new ArticleVenduManager();
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 43 */       List<Categorie> listeCategories = articleVenduManager.afficherCategories();
/*    */       
/* 45 */       request.setAttribute("listeCategories", listeCategories);
/* 46 */     } catch (Exception e) {
/* 47 */       e.printStackTrace();
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 54 */     if (request.getParameter("nomArticle") == null) {
/*    */       
/* 56 */       RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
/* 57 */       rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */     }
/*    */     else {
/*    */       
/* 61 */       String nomArticle = request.getParameter("nomArticle");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 68 */       Categorie categorie = new Categorie();
/* 69 */       categorie.setNoCategorie(Integer.valueOf(request.getParameter("categorie")).intValue());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 75 */       RequestDispatcher rd = request.getRequestDispatcher("/listeArticles");
/* 76 */       rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 87 */     doGet(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\ihm\AccueilServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */