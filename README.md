[TOC]
# HelpService
Help的后台系统






<div id="headerContainer">
    <a href="https://zjlloveo0.github.io" id="logo" target="_blank">
        <div class="blog-logo">
            <img src="img/head.png" title="zjlloveo0"/>
        </div>
        <div>
            zjlloveo0
        </div>
    </a>
    <div id="blogDesc">
        zjlloveo0@foxmail.com
    </div>
</div>

<style>
/*侧边栏*/
.toc a {
    color: #2e2e2e;
    text-decoration: none;
}
.toc a:hover {
    background-color: #26a0da;
    color: white;
}
.blog-logo img{
    width: 130px;
    height: 130px;
}
#headerContainer {
    border: 1px solid #ddd;
    text-align:center;
    position: absolute;
    left: 0; top: 0;
    height: 200px;
    width: 20%;
    position:fixed;
    float: left;
}
#blogDesc{
    font-size: 1px;
}
.toc {
    position: absolute;
    left: 0;bottom:0;
    width: 20%;
    height: calc( 100% - 205px );
    max-height: calc( 100% - 205px );
    overflow-y: scroll;
    overflow-x: scroll;
    overflow：auto;
    position:fixed;
    float: left;    
}
html{
    overflow：auto;
    width: 80%;
    margin-left: 20%;
}
body{
    width: 99%;
    margin: 0px;
}
/*定义滚动条宽高及背景，宽高分别对应横竖滚动条的尺寸*/
::-webkit-scrollbar{
    width: 8px;
    height:8px;
    background-color: #f5f5f5;
}
/*定义滚动条的轨道，内阴影及圆角*/
::-webkit-scrollbar-track{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
    border-radius: 10px;
    background-color: #f5f5f5;
}
/*定义滑块，内阴影及圆角*/
::-webkit-scrollbar-thumb{
    height: 20px;
    border-radius: 10px;
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
    background-color: #555;
}
</style>