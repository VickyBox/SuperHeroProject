# 超級英雄應用程式

這是一個使用 Kotlin、MVVM 架構和 Jetpack Compose 開發的 Android 應用程式，用於展示超級英雄的資訊。

## 功能特色

### 核心功能
- ✅ 使用 Kotlin 開發
- ✅ 使用 SuperHero API 獲取角色資料
- ✅ 採用 MVVM 架構模式
- ✅ 使用 Jetpack Compose 構建 UI
- ✅ 支援中文介面

### 角色清單
- ✅ 透過 SuperHero API 取得超級英雄列表
- ✅ 以列表展示超級英雄的名字和各種屬性
- ✅ 支援點擊角色查看詳細資訊
- ✅ 實時搜尋功能

### 額外功能
- ✅ 圖片載入：使用 Coil 庫載入角色圖片
- ✅ 錯誤處理：API 請求失敗時提供友善的提示訊息
- ✅ 單元測試：包含 ViewModel 的測試
- ✅ 依賴注入：使用 Hilt 進行依賴管理
- ✅ 網路請求：使用 Retrofit 進行 API 調用

## 技術架構

### 架構模式
- **MVVM (Model-View-ViewModel)**: 分離業務邏輯和 UI 邏輯
- **Repository Pattern**: 統一數據訪問層
- **Dependency Injection**: 使用 Hilt 管理依賴

### 主要技術棧
- **Kotlin**: 主要開發語言
- **Jetpack Compose**: 現代化 UI 框架
- **Hilt**: 依賴注入框架
- **Retrofit**: 網路請求庫
- **Coil**: 圖片載入庫
- **Navigation Compose**: 導航框架
- **Coroutines & Flow**: 異步處理

### 項目結構
```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/superheroapp/
│   │   │   ├── data/
│   │   │   │   ├── model/          # 數據模型
│   │   │   │   ├── remote/         # 網路層
│   │   │   │   └── repository/     # 數據倉庫
│   │   │   ├── ui/
│   │   │   │   ├── components/     # UI 組件
│   │   │   │   ├── navigation/     # 導航
│   │   │   │   ├── screens/        # 頁面
│   │   │   │   ├── state/          # UI 狀態
│   │   │   │   ├── theme/          # 主題
│   │   │   │   └── viewmodel/      # ViewModel
│   │   │   ├── MainActivity.kt
│   │   │   └── SuperHeroApplication.kt
│   │   └── res/                    # 資源文件
│   └── test/                       # 測試文件
```

## API 資訊

本應用使用 [SuperHero API](https://superheroapi.com/) 來獲取超級英雄資料。

### API 端點
- 搜尋英雄: `GET /search/{name}`
- 獲取英雄詳情: `GET /{id}`
- 獲取能力值: `GET /{id}/powerstats`
- 獲取背景故事: `GET /{id}/biography`
- 獲取外觀資訊: `GET /{id}/appearance`
- 獲取職業資訊: `GET /{id}/work`
- 獲取關聯資訊: `GET /{id}/connections`
- 獲取圖片: `GET /{id}/image`

## 安裝和運行

### 前置需求
- Android Studio Arctic Fox 或更新版本
- Android SDK API 24 或更高
- Kotlin 1.9.10 或更高

### 安裝步驟
1. 克隆專案到本地
2. 在 Android Studio 中打開專案
3. 等待 Gradle 同步完成
4. 連接 Android 設備或啟動模擬器
5. 點擊 "Run" 按鈕運行應用

### 構建配置
專案使用 Gradle 進行構建管理，主要配置包括：
- 目標 SDK: 34
- 最低 SDK: 24
- Compose Compiler: 1.5.1

## 測試

### 單元測試
專案包含 ViewModel 的單元測試，使用以下測試框架：
- JUnit 4
- Mockito
- Turbine (Flow 測試)
- Coroutines Test

運行測試：
```bash
./gradlew test
```

## 功能說明

### 主頁面
- 顯示熱門超級英雄列表
- 支援搜尋功能
- 點擊英雄卡片進入詳情頁面

### 詳情頁面
- 顯示英雄的完整資訊
- 包含能力值進度條
- 顯示背景故事、外觀、職業等詳細資訊

### 錯誤處理
- 網路錯誤時顯示重試按鈕
- 搜尋無結果時顯示提示訊息
- 載入中顯示進度指示器

## 貢獻

歡迎提交 Issue 和 Pull Request 來改善這個專案。

## 授權

本專案採用 MIT 授權條款。 