<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
/* commonなjs */
var request;    // ←スクリプトエラーとならないように宣言
var response;

function include(filename) {
  include.seq = (include.seq)? include.seq + 1: 1;

  var id = new Date().getTime() + "-" + include.seq;
  var inc = document.createElement("iframe");

  inc.id = "inc-" + id;
  inc.src = filename;
  inc.style.display = "none";
  document.body.appendChild(inc);
  document.write("<span id=\"" + id + "\"></span>");
  
  var f = function() {
     inc = document.getElementById("inc-" + id);
     var s = inc.contentWindow.document.body.firstChild.innerHTML;
     document.getElementById(id).innerHTML = 
       s.split("&gt;").join(">").split("&lt;").join("<");
     document.body.removeChild(inc);
  };
  if (window.addEventListener) window.addEventListener('load', f, false);
  if (window.attachEvent) window.attachEvent('onload', f);
}
