
function checkcode(basePath){
    var XMLHttp = null;
    if (window.XMLHttpRequest) {
        XMLHttp = new XMLHttpRequest()
    } else if (window.ActiveXObject) {
        XMLHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    XMLHttp.onreadystatechange = function() {
        if (XMLHttp.readyState == 4) {
            document.getElementById("imageCode").src = basePath
                + "validateCode?" + new Date();//改变验证码图片
        }
    }
    //将请求发送出去
    //加上new Date()防止浏览器缓存，不重新发送请求
    XMLHttp.open("GET", basePath + "validateCode?" + new Date(), true);
    XMLHttp.send(null);
}


// 刷新图片
function changeImg() {

    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src", changeUrl(src));
}
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function changeUrl(url) {
    var timestamp = (new Date()).valueOf();
    var index = url.indexOf("?",url);
    if (index > 0) {
        url = url.substring(0, url.indexOf(url, "?"));
    }
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}



//----------------------
// $(function(){
//     var options = {
//         type: 'POST',
//         url: 'cos-pc/login',
//         success:showResponse,
//         dataType: 'json',
//         error : function(xhr, status, err) {
//             alert("操作失败");
//         }
//     };
//     $("#loginform").submit(function(){
//         $(this).ajaxSubmit(options);
//         return false;   //防止表单自动提交
//     });
// });
//
// /**
//  * 保存操作
//  */
// function toSave(){
//     $("#loginform").submit();
// }
//
// /**
//  * 保存后，执行回调
//  * @param responseText
//  * @param statusText
//  * @param xhr
//  * @param $form
//  */
// function showResponse(responseText, statusText, xhr, $form){
//     if(responseText.status == "0"){
//         /**
//          * 请求成功后的操作
//          */
//         alert(responseText.msg);
//     } else {
//         alert(responseText.msg);
//     }
// }

$(document).ready(function() {
// 使用 jQuery异步提交表单
    $('#loginform').submit(function() {
        jQuery.ajax({
            url:'/cos-pc/login',
            dataType:"json",
            data:$('#loginform').serialize(),
            type:"POST",
            beforeSend:function()
            {
               alert(123)
            },
            success:function()
            {
              alert(456)
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                alert(XMLHttpRequest.responseText)
            }

        });
        return false;
    });
});
function submitForm(){
    $('#loginform').submit();
}

//---------------------

function clearForm(){
    $('#loginform').form('clear');
}
//回车登录
function enterlogin(){
    if (event.keyCode == 13){
        event.returnValue=false;
        event.cancel = true;
        $('#loginform').submit();
    }
}
