# 🚨 Emergency SOS Web App

A simple web-based Emergency SOS system built using **Spring Boot** and **HTML/JavaScript**, which allows users to trigger an emergency alert (SMS) to predefined contacts. This can be life-saving in distress situations.

---

## 🧠 Project Idea

The idea is to provide a **single-click emergency response system** that can instantly notify loved ones via SMS, with future support for location sharing and auto-image capture.

---

## 🔧 Features

- 🆘 One-click SOS button (on HTML page)
- 📲 Sends SMS via [Fast2SMS](https://www.fast2sms.com)
- 🔐 API secured with POST requests
- ✅ Swagger UI for API testing
- 📦 Easily extendable to mobile or React frontend
- 📍 Future-ready for GPS, camera, and email support

---

## 🖥️ Tech Stack

| Layer           | Technology         |
|----------------|--------------------|
| Frontend       | HTML + JavaScript  |
| Backend        | Spring Boot (Java) |
| SMS API        | Fast2SMS           |
| API Docs       | Swagger (OpenAPI)  |

---

## 📁 Project Structure

```

src/
├── main/
│   ├── java/
│   │   └── com.yourdomain.sos/
│   │       ├── controller/
│   │       │   └── SosController.java
│   │       ├── dto/
│   │       │   └── SosRequest.java
│   │       └── service/
│   │           └── SmsService.java
│   └── resources/
│       ├── static/
│       │   └── sos.html
│       └── application.properties

````

---

## 🚀 How to Run

1. Clone the repo  
   ```bash
   git clone https://github.com/yourusername/emergency-sos-app.git
   cd emergency-sos-app
````

2. Add your Fast2SMS API Key in `SmsService.java`

   ```java
   private static final String API_KEY = "your-api-key";
   ```

3. Run the app

   ```bash
   ./mvnw spring-boot:run
   ```

4. Open in browser:
   `http://localhost:8080/sos.html`

---

## 📌 API Endpoints

* `POST /api/sos`
  Trigger SOS with message and phone number.

Example request:

```json
{
  "message": "I need help. Urgent!",
  "phoneNumber": "9111110000"
}
```

---

## 🛡️ Future Enhancements

* 🧭 Auto geo-location capture
* 📷 Front-camera photo on trigger
* 📧 Email alerts to emergency contacts
* 📱 React Native mobile app
* 🧠 AI for detecting distress patterns

---

## 🙋‍♂️ Author

Made with ❤️ by Aditya

---

## 🤝 Contributing

Pull requests are welcome! Please open an issue first to discuss what you would like to change.

---

## 📄 License

This project is licensed under me.

```
