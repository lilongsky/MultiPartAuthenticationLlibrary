//todo: fix package problem download all package and import
import {nanoid} from "/nanoid";
import SHA256 from '/crypto-js/sha256';
import hmacSHA512 from 'crypto-js/hmac-sha512';
export function LoginFirst(formid, userid, userpswid, md5pswid,urlOfFirstLogin) {
    //const CryptoJS = require("crypto-js");
    let
        username = $('#' + userid),
        userpsw = $('#' + userpswid),
        sha256psw = $('#' + md5pswid),
        devOpt = $('input[name=devOption]')

    sha256psw.val(SHA256(encodeURIComponent(userpsw.val())));
    function PAPPost(url){
        $.post(url,
            {
                "code":1,
                "username": username.val(),
                "md5psw": sha256psw.val(),
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
    
    function CHAPGetRandomValue(url,id) {
        $.get(url,
            {
                "id":id,
                "devOpt": devOpt.val()
            },"text"
        ).done(function (data){
                return data;
        }).fail(function (data) {
            return data;
        })
    }

    function CHAPPost(url,id,cValue) {
        $.post(url,
            {
                "id":id,

            }
        )
    }
    
    if (devOpt.val() === "PAP"){
        PAPPost(urlOfFirstLogin);
    }else if (devOpt.val() === "CHAP"){
        let challengeID = nanoid(16);
        let challengeValue = CHAPGetRandomValue(urlOfFirstLogin,challengeID);

        
    }


//     $.post({
//         url: "login-first", //url dev input
//         async: true,
//         cache: false,
//         dataType: "text",
//         data: {
//             "username": username.val(),
//             "sha256psw": sha256psw.val(),
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

