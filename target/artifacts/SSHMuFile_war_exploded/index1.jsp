<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/13
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<html>
<head>
    <title>test</title>
    <script type="text/javascript" src="/uploadify/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/uploadify/jquery.uploadify.js"></script>
    <link type="text/css" rel="stylesheet" href="/uploadify/uploadify.css">
    <link href="/jPlayer-2.9.2/dist/skin/blue.monday/css/jplayer.blue.monday.min.css" rel="stylesheet" type="text/css"/>
   <%-- <script type="text/javascript" src="/jPlayer-2.9.2/lib/jquery.min.js"></script>--%>
   <script type="text/javascript" src="/jPlayer-2.9.2/dist/jplayer/jquery.jplayer.min.js"></script>
    <script type="text/javascript" src="/jPlayer-2.9.2/dist/add-on/jplayer.playlist.min.js"></script>
   <script type="text/javascript">

       /*$(function() {
         $("#custom_file_upload").uploadify({
           height        : 30,
           swf           : '/uploadify/uploadify.swf',
           uploader      : '/uploadify/uploadify.php',
           width         : 120,
           'cancelImg': '/uploadify/uploadify-cancel.png',
           'folder': '/Upload',
           'queueID': 'custom-queue',
           'queueSizeLimit': 10,
           'simUploadLimit': 10,
           'removeCompleted': true,
           'onSelectOnce': function (event, data) {
            // $('#status-message').text(data.filesSelected + ' 个文件加入上传队列');
           },
           'onClearQueue': function (event, data) {
             //$('#status-message').text('请选择要上传的文件:');
           },
           'onComplete': function (event, queueId, fileObj, response, data) {
             //alert(response.split('|')[1]); //这里获取上传后的URL路径，用来在前台显示
             //window.parent.document.getElementById('&lt;%&ndash;<%--<%=file_id %>--%>&ndash;%&gt;').value += response.split('|')[1] + space;
           },
           'onAllComplete': function (event, data) {
             //$('#status-message').text(data.filesUploaded + ' 个文件已上传');
           }
         });


       });*/
     </script>
</head>
<body>
<form action="data_save.action" method="post">
    name:<input type="text" name="data.name"/></br>
    description:<input type="text" name="data.description"/></br>
    test<input type="checkbox" name="test1" value="1"/></br>
    <div id="fileQueue"></div>
    <input type="file" name="uploadify" id="uploadify"/>
    <div id="fileList">
    </div>
    <input type="submit" value="add"/>
    <%--<input type="file" id="file_upload_1" >--%>

    <p>
        <!-- 上传第一个未上传的文件 -->
        <a href="javascript:$('#uploadify').uploadify('upload')">上传</a>
        <!-- 取消第一个未取消的文件 -->
        <a href="javascript:$('#uploadify').uploadify('cancel')">取消上传</a>

        <a href="javascript:$('#uploadify').uploadify('upload','*')">开始上传所有文件</a>&nbsp;
        <a href="javascript:$('#uploadify').uploadify('cancel','*')">取消所有上传</a>
    </p>


</form>
<%--<div id="custom-queue"></div>
<input id="custom_file_upload" type="file" name="Filedata" class="button" />
<input type="button" id="Up" name="Up" value="上传" class="button" />
<input type="button" id="Clear" name="Clear" value="清空" class="button" />--%>
<div style="float: left;margin-right: 100px;">

    <table id="lyc">
        <tr>
            <th>name</th>
            <th>desc</th>
            <th>down</th>
        </tr>

        <c:iterator value="#request.list" var="l">
            <tr>
                <td>${l.name}</td>
                <td>${l.description}</td>
                <td>
                    <c:iterator value="#l.files" var="f">
                    <ul>
                        <li>
                                ${f.fileName}
                            <a href="/servlet/Down?path=${f.filePath}&fileName=${f.fileName}">下载</a>

                        </li>
                     </ul>
                    </c:iterator>
                </td>
            </c:iterator>
        </tr>
    </table>
</div>

<!--播放器 -->
<div style="float: left">
<div id="jquery_jplayer_1" class="jp-jplayer"></div>
<div id="jp_container_1" class="jp-audio" role="application" aria-label="media player">
    <div class="jp-type-playlist">
        <div class="jp-gui jp-interface">
            <div class="jp-controls">
                <button class="jp-previous" role="button" tabindex="0">previous</button>
                <button class="jp-play" role="button" tabindex="0">play</button>
                <button class="jp-next" role="button" tabindex="0">next</button>
                <button class="jp-stop" role="button" tabindex="0">stop</button>
            </div>
            <div class="jp-progress">
                <div class="jp-seek-bar">
                    <div class="jp-play-bar"></div>
                </div>
            </div>
            <div class="jp-volume-controls">
                <button class="jp-mute" role="button" tabindex="0">mute</button>
                <button class="jp-volume-max" role="button" tabindex="0">max volume</button>
                <div class="jp-volume-bar">
                    <div class="jp-volume-bar-value"></div>
                </div>
            </div>
            <div class="jp-time-holder">
                <div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
                <div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
            </div>
            <div class="jp-toggles">
                <button class="jp-repeat" role="button" tabindex="0">repeat</button>
                <button class="jp-shuffle" role="button" tabindex="0">shuffle</button>
            </div>
        </div>
        <div class="jp-playlist">
            <ul>
                <li>&nbsp;</li>
            </ul>
        </div>
        <div class="jp-no-solution">
            <span>Update Required</span>
            To play the media you will need to either update your browser to a recent version or update your <a
                href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
        </div>
    </div>
</div>
</div>
<a href="listPage.action">go </a>
<!--播放器结束 -->
</body>

<script type="text/javascript">
    $(document).ready(function () {
        $("#uploadify").uploadify({
            'uploader': '/servlet/Upload',
            'swf': '/uploadify/uploadify.swf',
            'cancelImg': 'uploadify/uploadify-cancel.png',
            'folder': 'uploads',//您想将文件保存到的路径
            'queueID': 'fileQueue',//与下面的id对应
            'queueSizeLimit': 5,
            'fileTypeDesc': 'rar文件或zip文件',
            'fileTypeExts': '*.rar;*.zip;*.mp3', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc '*.rar;*.zip'
            'auto': false,
            'multi': true,
            'fileSizeLimit': '20000kb',
            'simUploadLimit': 5,
            'buttonText': '选择文件1',
            'onSelect': function (file) {//当每个文件添加至队列后触发
                /*alert( 'id: ' + file.id
                 + ' - 索引: ' + file.index
                 + ' - 文件名: ' + file.name
                 + ' - 文件大小: ' + file.size
                 + ' - 类型: ' + file.type
                 + ' - 创建日期: ' + file.creationdate
                 + ' - 修改日期: ' + file.modificationdate
                 + ' - 文件状态: ' + file.filestatus);*/
            },
            'onSelectError': function (file, errorCode, errorMsg) {//当文件选定发生错误时触发
                /*alert( 'id: ' + file.id
                 + ' - 索引: ' + file.index
                 + ' - 文件名: ' + file.name
                 + ' - 文件大小: ' + file.size
                 + ' - 类型: ' + file.type
                 + ' - 创建日期: ' + file.creationdate
                 + ' - 修改日期: ' + file.modificationdate
                 + ' - 文件状态: ' + file.filestatus
                 + ' - 错误代码: ' + errorCode
                 + ' - 错误信息: ' + errorMsg);*/
            },
            'onDialogClose': function (swfuploadifyQueue) {//当文件选择对话框关闭时触发
                /*if( swfuploadifyQueue.filesErrored > 0 ){
                 alert( '添加至队列时有'
                 +swfuploadifyQueue.filesErrored
                 +'个文件发生错误n'
                 +'错误信息:'
                 +swfuploadifyQueue.errorMsg
                 +'n选定的文件数:'
                 +swfuploadifyQueue.filesSelected
                 +'n成功添加至队列的文件数:'
                 +swfuploadifyQueue.filesQueued
                 +'n队列中的总文件数量:'
                 +swfuploadifyQueue.queueLength);
                 }*/
            },
            'onQueueComplete': function (stats) {//当队列中的所有文件全部完成上传时触发
                /* alert( '成功上传的文件数: ' + stats.uploadsSuccessful
                 + ' - 上传出错的文件数: ' + stats.uploadsErrored
                 );*/
            },
            'onUploadComplete': function (file, swfuploadifyQueue) {//队列中的每个文件上传完成时触发一次
                /*alert( 'id: ' + file.id
                 + ' - 索引: ' + file.index
                 + ' - 文件名: ' + file.name
                 + ' - 文件大小: ' + file.size
                 + ' - 类型: ' + file.type
                 + ' - 创建日期: ' + file.creationdate
                 + ' - 修改日期: ' + file.modificationdate
                 + ' - 文件状态: ' + file.filestatus);*/

            },
            'onUploadError': function (file, errorCode, errorMsg, errorString, swfuploadifyQueue) {//上传文件出错是触发（每个出错文件触发一次）
                /*alert( 'id: ' + file.id
                 + ' - 索引: ' + file.index
                 + ' - 文件名: ' + file.name
                 + ' - 文件大小: ' + file.size
                 + ' - 类型: ' + file.type
                 + ' - 创建日期: ' + file.creationdate
                 + ' - 修改日期: ' + file.modificationdate
                 + ' - 文件状态: ' + file.filestatus
                 + ' - 错误代码: ' + errorCode
                 + ' - 错误描述: ' + errorMsg
                 + ' - 简要错误描述: ' + errorString);*/
            },
            'onUploadProgress': function (file, fileBytesLoaded, fileTotalBytes, queueBytesLoaded, swfuploadifyQueueUploadSize) {//上传进度发生变更时触发
                /* alert( 'id: ' + file.id
                 + ' - 索引: ' + file.index
                 + ' - 文件名: ' + file.name
                 + ' - 文件大小: ' + file.size
                 + ' - 类型: ' + file.type
                 + ' - 创建日期: ' + file.creationdate
                 + ' - 修改日期: ' + file.modificationdate
                 + ' - 文件状态: ' + file.filestatus
                 + ' - 当前文件已上传: ' + fileBytesLoaded
                 + ' - 当前文件大小: ' + fileTotalBytes
                 + ' - 队列已上传: ' + queueBytesLoaded
                 + ' - 队列大小: ' + swfuploadifyQueueUploadSize);*/
            },
            'onUploadStart': function (file) {//上传开始时触发（每个文件触发一次）
                /* alert( 'id: ' + file.id
                 + ' - 索引: ' + file.index
                 + ' - 文件名: ' + file.name
                 + ' - 文件大小: ' + file.size
                 + ' - 类型: ' + file.type
                 + ' - 创建日期: ' + file.creationdate
                 + ' - 修改日期: ' + file.modificationdate
                 + ' - 文件状态: ' + file.filestatus );*/
            },
            'onUploadSuccess': function (file, data, response) {//上传完成时触发（每个文件触发一次）
                /*alert( 'id: ' + file.id
                 + ' - 索引: ' + file.index
                 + ' - 文件名: ' + file.name
                 + ' - 文件大小: ' + file.size
                 + ' - 类型: ' + file.type
                 + ' - 创建日期: ' + file.creationdate
                 + ' - 修改日期: ' + file.modificationdate
                 + ' - 文件状态: ' + file.filestatus
                 + ' - 服务器端消息: ' + data
                 + ' - 是否上传成功: ' + response);*/
                $("#fileList").append("<li><input checked='checked' type='checkbox' name='files' value=" + "'" + data + "--" + file.name + "'" + "/>" + "</li>");
            }
        });
    });
</script>
<!--播放器初始化 -->
<script type="text/javascript">

    //<![CDATA[
    $(document).ready(function(){
        var nodes = new Array();
        //var obj = {title:"hahhh",mp3:"1.mp3"};
        //nodes.push(obj);
        $("#lyc ul li").each(function(){
            var title = $(this).text();
            var mp3 = $(this).find("a").attr("href");
            mp3 = mp3.substr(mp3.indexOf("uploads")+7,mp3.indexOf("&")-mp3.indexOf("path")-5);
            mp3 ="\\uploads" +mp3;
            mp3 = mp3.substr(0,mp3.indexOf("&") )
            var obj = {title:title,mp3:mp3};
            nodes.push(obj);
          // debugger;
        });
        new jPlayerPlaylist({
            jPlayer: "#jquery_jplayer_1",
            cssSelectorAncestor: "#jp_container_1"
        }, nodes
        , {
            swfPath: "/jPlayer-2.9.2/dist/jplayer",
            supplied: "oga, mp3",
            wmode: "window",
            useStateClassSkin: true,
            autoBlur: false,
            smoothPlayBar: true,
            keyEnabled: true
        });
    });
    //]]>
</script>
</html>
