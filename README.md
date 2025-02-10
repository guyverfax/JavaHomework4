
#專案說明
這是一個購物系統，包含會員和訂單管理，並基於 MVC（Model-View-Controller） 設計模式來組織系統架構。系統包含 DAO（Data Access Object） 層和 Service 層，後端使用 MySQL 進行資料庫操作。

##目錄結構如下：
```
Homework4\src
├─controller
│  ├─member
│  │   AddMemberErrorUI.java
│  │   AddMemberSuccessUI.java
│  │   AddMemberUI.java
│  │   LoginErrorUI.java
│  │   LoginSuccessUI.java
│  │   LoginUI.java
│  └─porder
│       AddPorderUI.java
│       PorderMainUI.java
│       PorderManagerUI.java
├─dao
│  ├─MemberDao.java
│  ├─PorderDao.java
│  └─impl
│       MemberDaoImpl.java
│       PorderDaoImpl.java
├─model
│   Member.java
│   Porder.java
├─service
│   MemberService.java
│   PorderService.java
│   └─impl
│       MemberServiceImpl.java
│       PorderServiceImpl.java
└─util
    DbConnection.java

##檔案說明如下:
src/controller/
Controller 層 負責 UI 控制邏輯，通常與使用者互動，接收輸入並調用 Service 層來處理業務邏輯。

📁 controller/member/ 用於會員（Member）相關的 UI 控制。
AddMemberUI.java 新增會員的 UI 介面。
AddMemberSuccessUI.java 顯示會員成功新增的介面。
AddMemberErrorUI.java 顯示會員新增失敗的介面。
LoginUI.java 會員登入的 UI 介面。
LoginSuccessUI.java 顯示會員成功登入的介面。
LoginErrorUI.java 顯示登入失敗的介面。
📁 controller/porder/ 用於訂單（Porder，可能指 Purchase Order）相關的 UI 控制。
AddPorderUI.java 用於新增訂單的 UI 介面。
PorderMainUI.java 訂單管理的主介面。
PorderManagerUI.java 負責訂單的詳細管理介面。
📂 src/dao/ DAO（Data Access Object）層，負責資料庫的存取操作。
MemberDao.java 會員（Member）相關的資料庫操作接口（例如：CRUD）。
PorderDao.java 訂單（Porder）相關的資料庫操作接口。
📁 dao/impl/ DAO 的具體實作類別（impl 代表 implementation）。
MemberDaoImpl.java MemberDao 介面的實作，負責與資料庫互動（如：新增會員、查詢會員資料等）。
PorderDaoImpl.java PorderDao 介面的實作，負責訂單的資料存取。
📂 src/model/ Model 層，負責定義應用程式的業務數據結構。
Member.java 會員（Member）類別，包含會員的屬性（如 id、name、email）。
Porder.java 訂單（Porder）類別，包含訂單的屬性（如 orderId、memberId、orderDate）。
📂 src/service/ Service 層，負責業務邏輯處理，通常會調用 DAO 層來處理資料。
MemberService.java 定義會員相關的業務邏輯（例如：註冊會員、驗證登入）。
PorderService.java 定義訂單相關的業務邏輯（例如：建立訂單、取消訂單）。
📁 service/impl/ Service 的具體實作類別。
MemberServiceImpl.java MemberService 介面的實作，處理會員的業務邏輯。
PorderServiceImpl.java PorderService 介面的實作，處理訂單的業務邏輯。
📂 src/util/ 工具類別與通用功能。
DbConnection.java 負責管理資料庫的連線，例如: JDBC 連線設定。
PorderTableModel.java Swing 的 TableModel，用來顯示訂單資料。
Tool.java 一個通用工具類別輔助函數。
```

##主頁的檔案說明如下:
Homework4.jar 是執行檔
fruit_member.sql 和 fruit_porder.sql 是 MySQL Schema 和 Table

##使用手冊
###1.匯入 MySQL Schema 和 Table
請下載 fruit_member.sql 和 fruit_porder.sql，並按照以下步驟將其匯入 MySQL：
使用 MySQL Workbench 匯入資料：
打開 MySQL Workbench。
連接到 MySQL 伺服器。
在左側資料庫樹狀中，選擇要匯入資料的資料庫。
在 MySQL Workbench 上方的「管理」標籤下，選擇 資料匯入。
選擇要匯入的檔案（例如 fruit_member.sql 或 fruit_porder.sql）。
點擊 開始匯入。
匯入完成後，資料庫中的 Schema 和表格應已成功設置。

###2.準備好 Java 11 可執行環境
以 Windows 10 為範例，請確保您已經安裝 Java 11。可以透過以下指令檢查 Java 環境是否已設置，在命令提示字元中執行：
C:\>javac -version
javac 11.0.20

C:\>java -version
java version "11.0.20" 2023-07-18 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.20+9-LTS-256)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.20+9-LTS-256, mixed mode)
若能正確顯示版本資訊，代表您的 Java 環境已成功安裝。

##3.下載執行檔
請下載 Homework4.jar 檔案。下載完成後，您只需點擊該檔案即可開啟程式。

