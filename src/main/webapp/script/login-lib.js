import "./jquery.md5.js"
export function LoginFirst(formid, userid, userpswid, md5pswid) {
    let
        username = $('#' + userid),
        userpsw = $('#' + userpswid),
        md5psw = $('#' + md5pswid),
        devOpt = $('input[name=devOption]')

    function PAPPost(){
        md5psw.val($.md5(encodeURIComponent(userpsw.val())));
        $.post("login-first",
            {
                "code":1,
                "username": username.val(),
                "md5psw": md5psw.val(),
                "devOpt": devOpt.val()
            },"text")

            .done(function (data) {
                console.log(data);
                if (data === "success") {
                    alert("login success");
                } else {
                    alert("login fail");
                }
            })
            .fail(function () {
                alert("unknow error");
            })
    }
    
    function CHAPPost() {
        $.get("login-first",
            {
                "devOpt": devOpt.val()
            }
        )
    }
    
    
    PAPPost();

//     $.post({
//         url: "login-first", //url dev input
//         async: true,
//         cache: false,
//         dataType: "text",
//         data: {
//             "username": username.val(),
//             "md5psw": md5psw.val(),
//             "devOpt": devOpt.val()
//         }
//     })
//         .done(function (data) {
//             console.log(data);
//             if (data === "success") {
//                 alert("login success");
//             } else {
//                 alert("login fail");
//             }
//         })
//         .fail(function () {
//             alert("unknow error");
//         })
 }

