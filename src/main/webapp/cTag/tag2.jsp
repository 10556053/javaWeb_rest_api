<%-- 
    Document   : tag2
    Created on : 2020/9/14, 下午 07:36:21
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/WEB-INF/tlds/my_tld" prefix="my"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom Tag Demo</title>
    </head>
    <body>
        <h1><my:hello/></h1>
        <h1><my:hellouser name="bob"/></h1>
        <h1><my:calcbmi  h="170" w="60"/></h1>
        <h1><my:stock symbol="TWDUSD=x" qty="10000" /></h1>
        <h1>
            <my:lotto amount="6">
                樂透彩開獎:
            </my:lotto>
        </h1>

        <h1>
            <my:loop count="9">
                中秋節
            </my:loop>
        </h1>

        <h1>
            <my:search key="小鬼" key2="程序">
                藝人小鬼（黃鴻升）本月16日在位於台北市北投區的住所驟逝，享年36歲。檢警相驗遺體後，初步排除外力介入，經家屬同意，檢警今天下午2時30分會同法醫在板橋殯儀館解剖釐清死因，結束後檢察官王乙軒步出解剖中心接受訪問，她指出，初步解剖發現，小鬼死因疑似是心血管的問題。

                小鬼在16日上午11時許被59歲父親發現時已無生命跡象，身上僅穿著白色短t、下身赤裸，他臉朝下趴地，口鼻流血、嘴唇撞腫，研判是慌張走出浴室，突然因不明原因摔倒，臉部撞到流血，屋內無發現藥物、也沒有喝酒情事。

                今天下午檢警會同法醫在板橋殯儀館進行解剖程序，小鬼父親與妹妹均到場，程序結束後，負責解剖程序的檢察官王乙軒接受訪問，表示初步解剖發現，小鬼死因疑似是心血管的問題，沒有明顯外傷，遺體已經發還家屬，詳細死因還有待法醫研究所的鑑定報告。
            </my:search>
        </h1>
        
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>Symbol</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <my:stockList>
                    2330.TW,2317.TW,USDTWD=x
                </my:stockList>
            </tbody>
        </table> 
        
        <h1>
            <my:helloSimple msg="Java" />
        </h1>
        
        <h1>
            <my:add x="10" y="20" z="30" />
        </h1>
    </body>
</html>
