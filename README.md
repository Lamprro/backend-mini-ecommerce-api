# Mini E-commerce Backend API

Đây là dự án Backend cho bài test tuyển dụng vị trí thực tập sinh tại Leadsgen.
Dự án cung cấp RESTful API quản lý sản phẩm và giỏ hàng, được xây dựng bằng Java Spring Boot.

## 🚀 Công nghệ sử dụng

*   **Java**: 17 
*   **Framework**: Spring Boot 3.5.11
*   **Build Tool**: Maven
*   **Database**: H2 Database (In-memory)
*   **Thư viện khác**: Spring Data JPA, Lombok, Validation

## 📦 Cài đặt và Chạy ứng dụng

### Yêu cầu tiên quyết
*   JDK 17 trở lên đã được cài đặt.
*   Maven (thường đi kèm với IDE như IntelliJ).

### Các bước thực hiện
1.  **Clone repository:**
    ```bash
    git clone `https://github.com/Lamprro/backend-mini-ecommerce-api`
    cd demo
    ```

2.  **Mở dự án:**
    *   Khởi động IntelliJ IDEA (hoặc Eclipse).
    *   Chọn **Open** và trỏ đến thư mục dự án vừa clone.
    *   Đợi Maven tải các thư viện cần thiết.

3.  **Chạy ứng dụng:**
    *   Tìm file `src/main/java/com/example/demo/BackendMiniEcommerceApiApplication.java`.
    *   Nhấn chuột phải chọn **Run 'BackendMiniEcommerceApiApplication'**.
    *   Ứng dụng sẽ khởi động tại cổng `8080`.

## 🗄️ Database & Dữ liệu mẫu

Dự án sử dụng H2 Database (lưu trữ trên RAM) và tự động nạp dữ liệu mẫu khi khởi động từ file `src/main/resources/data.sql`.

*   **H2 Console URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
*   **JDBC URL**: `jdbc:h2:mem:pos_db`
*   **User Name**: `sa`
*   **Password**: (để trống)

## 📡 Tài liệu API (API Documentation)

Dưới đây là danh sách các API chính đã được triển khai.

### 1. Sản phẩm (Products)

*   **Lấy danh sách sản phẩm**
    *   `GET /products`
    *   Query Params:
        *   `limit`: Số lượng sản phẩm (mặc định 12)
        *   `skip`: Số lượng bỏ qua (mặc định 0)
    *   Ví dụ: `http://localhost:8080/products?limit=10&skip=0`

*   **Lấy chi tiết sản phẩm**
    *   `GET /products/{id}`
    *   Ví dụ: `http://localhost:8080/products/1`

### 2. Giỏ hàng (Cart)

*   **Lấy giỏ hàng của User**
    *   `GET /carts/user/{userId}`
    *   Ví dụ: `http://localhost:8080/carts/user/1`

*   **Thêm sản phẩm vào giỏ**
    *   `POST /carts/add`
    *   Body (JSON):
        ```json
        {
          "userId": 1,
          "items": [
            { "productId": 1, "quantity": 2 },
            { "productId": 3, "quantity": 1 }
          ]
        }
        ```

*   **Cập nhật số lượng sản phẩm**
    *   `PUT /carts/user/{userId}/products/{productId}?quantity={newQuantity}`
    *   Ví dụ: `http://localhost:8080/carts/user/1/products/1?quantity=5`

*   **Xóa sản phẩm khỏi giỏ**
    *   `DELETE /carts/user/{userId}/products/{productId}`
    *   Ví dụ: `http://localhost:8080/carts/user/1/products/1`

*   **Xóa sạch giỏ hàng (Clear Cart)**
    *   `DELETE /carts/user/{userId}`
    *   Ví dụ: `http://localhost:8080/carts/user/1`

## 📂 Cấu trúc dự án


```text
src/main/java/com/example/demo/
├── Controller/       # Xử lý HTTP Request (API Layer)
│   └── DTO/          # Data Transfer Objects
├── Service/          # Logic nghiệp vụ (Business Layer)
├── Repository/       # Tương tác Database (Data Access Layer)
├── Entity/           # Các thực thể JPA (Product, Cart, CartItem)
└── Exception/        # Xử lý lỗi tập trung (Global Exception Handler)
```


## 📝 Ghi chú về AI

Quá trình phát triển có sử dụng sự hỗ trợ của AI. Chi tiết xem tại file `AI_USAGE.md`.

