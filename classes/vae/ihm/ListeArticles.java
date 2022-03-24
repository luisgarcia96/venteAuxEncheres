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
/*    */ import javax.servlet.http.HttpSession;
/*    */ import vae.bll.ArticleVenduManager;
/*    */ import vae.bo.ArticleVendu;
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
/*    */ @WebServlet({"/listeArticles"})
/*    */ public class ListeArticles
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 34 */     String nomArticle = request.getParameter("nomArticle");
/*    */ 
/*    */ 
/*    */     
/* 38 */     Categorie categorie = new Categorie();
/* 39 */     categorie.setNoCategorie(Integer.valueOf(request.getParameter("categorie")).intValue());
/*    */ 
/*    */ 
/*    */     
/* 43 */     HttpSession session = request.getSession();
/* 44 */     String login = (String)session.getAttribute("login");
/*    */ 
/*    */     
/* 47 */     ArticleVenduManager articleVenduManager = new ArticleVenduManager();
/*    */ 
/*    */     
/*    */     try {
/* 51 */       List<ArticleVendu> listeArticlesVendus = articleVenduManager.selectParNomEtCategorie(nomArticle, categorie);
/*    */       
/* 53 */       request.setAttribute("listeArticlesVendus", listeArticlesVendus);
/* 54 */     } catch (Exception e) {
/* 55 */       e.printStackTrace();
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 60 */       List<Categorie> listeCategories = articleVenduManager.afficherCategories();
/*    */       
/* 62 */       request.setAttribute("listeCategories", listeCategories);
/* 63 */     } catch (Exception e) {
/* 64 */       e.printStackTrace();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 69 */     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listeEncheres.jsp");
/* 70 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 78 */     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listeEncheres.jsp");
/* 79 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\ihm\ListeArticles.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */