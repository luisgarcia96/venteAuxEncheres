/*    */ package WEB-INF.classes.vae.ihm;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import vae.bll.UtilisateurManager;
/*    */ import vae.bo.Utilisateur;
/*    */ import vae.exceptions.BusinessException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebServlet({"/profil"})
/*    */ public class AfficherProfil
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 27 */     HttpSession session = request.getSession();
/*    */     
/* 29 */     String pseudo = (String)session.getAttribute("login");
/*    */     try {
/* 31 */       Utilisateur utilisateur = UtilisateurManager.getUtilisateurManager().selectUtilisateurByPseudo(pseudo);
/* 32 */       request.setAttribute("utilisateur", utilisateur);
/* 33 */       request.setAttribute("pseudo", pseudo);
/* 34 */     } catch (BusinessException e) {
/*    */       
/* 36 */       e.printStackTrace();
/*    */     } 
/*    */     
/* 39 */     RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/afficherProfil.jsp");
/* 40 */     rd.forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 47 */     doGet(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\ihm\AfficherProfil.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */