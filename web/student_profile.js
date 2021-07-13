/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Logout(){
  if (confirm("Willing to Logout??")) {
    window.location = "index.html";
  } else {
    txt = "You pressed Cancel!";
  }
        
}