
這是一個購物系統，包含會員和訂單管理，並基於 MVC（Model-View-Controller） 設計模式來組織系統架構。系統包含 DAO（Data Access Object） 層和 Service 層，後端使用 MySQL 進行資料庫操作。

目錄結構如下：

```
Homework4
src
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
    PorderTableModel.java
    Tool.java
```

