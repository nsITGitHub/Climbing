<h1 align="center">R o u t  S e t  D a y s</h1>
<h6 align="center">-ボルダリングジムのルート変更日を確認できるサイト-</h6>

![メイン画面1](https://github.com/nsITGitHub/Climbing/assets/167949592/a10496a8-1260-4272-886d-ff29c6418920)
![メイン画面2](https://github.com/nsITGitHub/Climbing/assets/167949592/d9c115ba-1524-4fbf-b258-0c11d08fe1a4)

## 背景 
ボルダリングジムは月に1回ほど課題(ルート)の変更をするために休業期間を設けています。<br>
さらにそれぞれのジムごとに休業日は異なるのでその都度調べなくてはいけません。<br>
また、ボルダリングジムでは多くのイベントを行っているが、その情報の取得も手軽とは言い難いと感じました。<br>
そこで私は複数のジムのルート変更日と実施してるイベントを一つのカレンダーにまとめて確認できるサイトを作成いいたしました。<br>


## 利用方法
- カレンダーで各ボルダリングジムのルート変更日とイベントを確認する。(黒枠:ルート変更日,赤枠:イベント)<br>
beforeボタンとafterボタンで月の変更が可能。
- serchで知りたいジムのルート変更日を検索する。
- NEWSから各jimの最新情報を知ることができる。<br>
イベントをクリックすることで元のURLへ行き、詳細情報を確認しに行ける。


## 要件定義
- ボルダリングジムのHPから必要情報を取得する。
- 取得した情報をDBに格納する。
- 月の更新が可能なカレンダーを作成する。
- 取得したルート変更日やイベントをカレンダーの該当する日付に埋め込む。
- カレンダー内のルート変更日をクリックすると詳細情報を確認できる。
- 各ジム事に調べられるように検索機能を作る。
- DBに格納する情報を更新できるようにする。
- イベントを一覧にして表示する。
- それぞれのイベントから元HPの詳細に飛べるようにする。


## 実装機能
/*
| 機能１ |　機能２ |
| ---- | ---- |
| ![Top画面](/docs/img/app-view/welcome_1.1.png) | ![ログイン画面](/docs/img/app-view/login_1.1.png) |
| 登録せずにサービスをお試しいただくためのトライアル機能を実装しました。 | ログインIDとパスワードでの認証機能を実装しました。 |
*/
- 月更新可能のカレンダーと各情報の埋め込み
- 各ジムごとの検索機能
- 情報の更新機能
- イベントの一覧表示

## DB設計  (DB名：climbing)
**各種テーブル**
- **calender**<br>
  ルート変更日に関する情報を格納するテーブル

 Field | Type         | Null | Key | Default | Extra          
-------|--------------|------|-----|---------|----------------
 id    | bigint       | NO   | PRI | NULL    | auto_increment 
 date  | int          | YES  |     | NULL    |                
 jim   | varchar(255) | YES  |     | NULL    |                
 month | int          | YES  |     | NULL    |                
 name  | varchar(255) | YES  |     | NULL    |                
 text  | varchar(255) | YES  |     | NULL    |                
 year  | int          | YES  |     | NULL    |              


- **news**<br>
  イベントに関する情報を格納するテーブル

 Field | Type         | Null | Key | Default | Extra          
-------|--------------|------|-----|---------|----------------
 id    | bigint       | NO   | PRI | NULL    | auto_increment 
 date  | int          | YES  |     | NULL    |               
 jim   | varchar(255) | YES  |     | NULL    |                
 link  | varchar(255) | YES  |     | NULL    |                
 month | int          | YES  |     | NULL    |                
 news  | varchar(255) | YES  |     | NULL    |                
 year  | int          | YES  |     | NULL    |                


## 開発環境
HTML|&ensp; CSS &ensp;|JavaScript |Java   |MySQL  |Spring|Selenium|Git |eclipse
:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:
5    |-    |-    |17.0.10|8.3.0  |3.2.4　　|4.19.1      |2.45.0 |4.30.0
フロント</span>|フロント|フロント|バック|データベース|フレームワーク|スクレイピング|管理|統合開発
 <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="html5" width="40" height="40"/> </a> |  <a href="https://www.w3schools.com/css/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="css3" width="40" height="40"/> </a>            | <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg" alt="javascript" width="40" height="40"/> </a>         | <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a>          |<a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a>          | <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a>                  |<a href="https://www.selenium.dev" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/detain/svg-logos/780f25886640cef088af994181646db2f6b1a3f8/svg/selenium-logo.svg" alt="selenium" width="40" height="40"/> </a>  |<a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/></a> 　　|<a href="https://willbrains.jp/" target="_blank" rel="noreferrer"> <img src="https://github.com/nsITGitHub/Climbing/blob/master/src/main/resources/static/img/eclipse.jpg" alt="eclipse" width="40" height="40"/></a>

## 工夫した点
- サイトからの情報取得（スクレイピング）は動的サイトにも対応できるようにSeleniumを採用した。
- serviceフォルダ内のseleniumを実装した複数のクラスはJim_Allクラスで一つのリストにまとめてからDBに格納するように設計した。<br>
 そうすることで今後ジムの種類を増やしたとしてもJim_All内のlistに追加するだけでよくなり、拡張性を意識した（画像用意）
- カレンダーは月更新やルート変更日の埋め込みなど動的な動作に対応できるようにjavascriptで作成。
- 今後ジムの種類が増えた時のためにジムごとに調べられるように検索機能を追加した。

## 苦労した点
- 初めての自主製作であったため全ての作業が手探りであった。
- Seleniumの環境構築と特定の要素を取り出すためのコードの書き方。
- JavasScriptでのカレンダー作成とカレンダー内に情報を埋め込む方法。
- フロントエンド、バックエンド、データベース間でのデータの受け渡し。

## 実装予定の機能
- ログイン機能を作成。ホストがログインしたときのみDBの更新を可能にする。
- 現在登録しているジムは一つのみだが、今後種類を増やしたい。
- カレンダーに簡単なメモを書き込めるようにしたい（ex.4/3 ジムに行く）。<br>
  また、そのデータをユーザーごとにDBに保管。

 
