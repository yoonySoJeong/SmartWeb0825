/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.60
 * Generated at: 2022-01-14 03:29:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/SmartWeb0825/springstudy/nearby/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/NEARBY/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1638260032713L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\"\r\n");
      out.write("\tintegrity=\"sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==\"\r\n");
      out.write("\tcrossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@10\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\tfnProfileBtn();\t\t\t// ?????? ?????? ????????? ???????????? ??? ??????, ????????????, ??????????????? ?????? ????????????\r\n");
      out.write("\t\t\tfnCheckLogin();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// fnProfileBtn();\r\n");
      out.write("\t\tfunction fnProfileBtn() {\r\n");
      out.write("\t\t\t$('#profile_box').click(function (){\r\n");
      out.write("\t\t\t\t$('#profile_menu').toggleClass('profile_see');\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t/* ----------------------------------------- fnCheckLogin() --------------------------------  */\r\n");
      out.write("\t\r\n");
      out.write(" \tfunction fnCheckLogin(){\r\n");
      out.write("\t\tlet loginInfo = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\tif (loginInfo == '') {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t Swal.fire({\r\n");
      out.write("\t\t\t\ttext: '????????? ?????????????????????. ????????? ???????????? ???????????????.',\r\n");
      out.write("\t\t        icon: 'warning',\r\n");
      out.write("\t\t        confirmButtonColor: '#D4D4D4',  // confirm\r\n");
      out.write("\t\t        confirmButtonText: '?????????',\r\n");
      out.write("\t\t     }).then((result) => {\r\n");
      out.write("\t\t\t\tif(result.isConfirmed) { // confirm??? false?????? return\r\n");
      out.write("\t\t\t\t\tlocation.href='/nearby/';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t     })\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\t \t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"left_box\">\r\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/board/boardList\">logo_img</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"mid_box\">\r\n");
      out.write("\t\t<ul class=\"btn_box\">\r\n");
      out.write("\t\t\t<li id=\"home_btn\" >\r\n");
      out.write("\t\t\t\t<a class=\"boxes\" href=\"");
      out.print(request.getContextPath());
      out.write("/board/boardList\"><i id=\"home_icon\" class=\"fas fa-home\"></i></a>\r\n");
      out.write("\t\t\t\t<div class=\"text_icon_box t1\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">???</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"myhome_btn\">\r\n");
      out.write("\t\t\t\t<a class=\"boxes\" href=\"");
      out.print(request.getContextPath());
      out.write("/board/myHome\"><i id=\"myhome_icon\" class=\"fas fa-border-all\"></i></a>\r\n");
      out.write("\t\t\t\t<div class=\"text_icon_box t2\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">?????????</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"follow_btn\">\r\n");
      out.write("\t\t\t\t<a class=\"boxes\" href=\"");
      out.print(request.getContextPath());
      out.write("/follow/followList\"><i id=\"follow_icon\" class=\"fas fa-user-friends\"></i></a>\r\n");
      out.write("\t\t\t\t<div class=\"text_icon_box t3\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">?????????</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li id=\"insert_btn\" >\r\n");
      out.write("\t\t\t\t<a class=\"boxes\" href=\"");
      out.print(request.getContextPath());
      out.write("/board/insertPage\"><i id=\"insert_icon\" class=\"far fa-plus-square\"></i></a>\r\n");
      out.write("\t\t\t\t<div class=\"text_icon_box t4\">\r\n");
      out.write("\t\t\t\t\t<a href=\"#\">??????/ ????????? ??????</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"right_box\">\r\n");
      out.write("\t\t<form class=\"main_search\" action=\"");
      out.print(request.getContextPath());
      out.write("/board/searchBoardList\">\r\n");
      out.write("\t\t\t<div class=\"search_box pointer\">\r\n");
      out.write("\t\t\t\t<input type=text id=\"query\" name=\"query\">\r\n");
      out.write("\t\t\t\t<button id=\"search_icon\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fas fa-search\"></i>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<div id=\"profile_box\">\r\n");
      out.write("   \t   \t \t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("\t\t<div id=\"profile_menu\" class=\"profile_no\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a id=\"profile_menu_list1\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("???<p>\r\n");
      out.write("\t\t\t\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("   \t   \t\t\t<li><a id=\"profile_menu_list2\" href=\"");
      out.print(request.getContextPath());
      out.write("/board/myHome\"><i class=\"fas fa-user-circle\"></i>&nbsp;&nbsp;?????????</a></li>\r\n");
      out.write("   \t   \t\t\t<li><a id=\"profile_menu_list3\" href=\"");
      out.print(request.getContextPath());
      out.write("/member/mypage\"><i class=\"fas fa-cog\"></i>&nbsp;&nbsp;????????? ??????</a></li>\r\n");
      out.write("   \t   \t\t\t<li><a id=\"profile_menu_list4\" href=\"");
      out.print(request.getContextPath());
      out.write("/member/changePasswordPage\"><i class=\"fas fa-key\"></i>&nbsp;&nbsp;???????????? ??????</a></li>\r\n");
      out.write("   \t   \t\t\t<li><a id=\"profile_menu_list5\" href=\"");
      out.print(request.getContextPath());
      out.write("/member/logout\"><i class=\"fas fa-sign-out-alt\"></i>&nbsp;&nbsp;????????????</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/layout/header.jsp(87,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty loginUser.profile.pSaved}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<img id=\"profile_img\" src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("/resources/image/profile_default.png\" class=\"pointer defaultImg\">\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/views/layout/header.jsp(90,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty loginUser.profile.pSaved}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<img id=\"profile_img\" src=\"/nearby/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.profile.pPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('/');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.profile.pSaved}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" class=\"pointer\">\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}
