/*    */ package WEB-INF.classes.vae.ihm;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
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
/*    */ import vae.exceptions.LectureMessage;
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
/*    */ @WebServlet({"/connexion"})
/*    */ public class ServletConnexion
/*    */   extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 40 */     request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 48 */     request.setCharacterEncoding("UTF-8");
/* 49 */     String login = request.getParameter("login");
/* 50 */     String motDePasse = request.getParameter("motDePasse");
/*    */ 
/*    */     
/* 53 */     MessageDigest md = null;
/*    */     try {
/* 55 */       md = MessageDigest.getInstance("SHA-256");
/* 56 */       md.update(motDePasse.getBytes());
/* 57 */       byte[] byteData = md.digest();
/*    */       
/* 59 */       StringBuffer sb = new StringBuffer();
/*    */       
/* 61 */       for (int i = 0; i < byteData.length; i++) {
/* 62 */         sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
/*    */       }
/* 64 */       motDePasse = sb.toString();
/*    */     }
/* 66 */     catch (NoSuchAlgorithmException e1) {
/*    */       
/* 68 */       e1.printStackTrace();
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 73 */       Utilisateur utilisateur = UtilisateurManager.getUtilisateurManager().connexion(login, motDePasse);
/*    */ 
/*    */       
/* 76 */       HttpSession session = request.getSession();
/* 77 */       session.setAttribute("login", utilisateur.getLogin());
/* 78 */       session.setAttribute("nom", utilisateur.getNom());
/* 79 */       session.setAttribute("administrateur", utilisateur.getAdministrateur());
/*    */ 
/*    */       
/* 82 */       request.getRequestDispatcher("accueil").forward((ServletRequest)request, (ServletResponse)response);
/*    */     }
/* 84 */     catch (BusinessException e) {
/*    */       
/* 86 */       request.setAttribute("erreur", LectureMessage.getMessageErreur(10000));
/*    */ 
/*    */       
/* 89 */       request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward((ServletRequest)request, (ServletResponse)response);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\luisa\Desktop\PROJETS ENI\ventesAuxEncheresBis\war\DW2M_G3_ventesAuxEncheres.war!\WEB-INF\classes\vae\ihm\ServletConnexion.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */