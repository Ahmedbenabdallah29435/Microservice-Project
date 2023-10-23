const express = require("express");
var bodyParser = require("body-parser");
const mongoose = require("mongoose");
const cors = require("cors");
const morgan = require("morgan");
var produitRouter = require("./router/produitRoutes");
var commandeRouter = require("./router/commandeRoutes");
// ------------------ Eureka Config --------------------------------------------
const eurekaHelper = require("./eureka-helper");

//----------------- end -----------------------------------------------------------
var configDb = require("./db.json");

const app = express();

/** middlewares */

/** middlewares */
app.use(express.json());

app.use(
  cors({
    origin: [
      "http://localhost:5001",
      "http://localhost:3000",
      "https://api.cloudinary.com",
      "http://localhost:5001/",
      "http://localhost:3000/"
    ],
    methods: ["POST", "GET", "PUT", "DELETE"],
    credentials: true,
    allowedHeaders: ["Content-Type"], // Add "Content-Type" to the list of allowed headers
    allowedHeaders: ["Content-Type"], // Add "Content-Type" to the list of allowed headers
  })
);
app.use(express.json());
////////////

app.use(morgan("tiny"));
app.disable("x-powered-by"); // less hackers know about our stack
// parse application/x-www-form-urlencoded
app.use(bodyParser.json({ limit: "500mb" }));
app.use(bodyParser.urlencoded({ limit: "500mb", extended: true }));
// parse application/json
app.use(bodyParser.json());
/**end Middlewares */

const port = 5000;

/** api routes */

app.use("/produit", produitRouter);
app.use("/commande", commandeRouter);

/** end api routes */

// connect  database
mongoose
  .connect(configDb.mongo.uri, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => {
    console.log("Connected successfully to MongoDB server");
    // Perform database operations here
  })
  .catch((err) => console.error(err));
/** end db conn */

app.listen(port, () => {
  console.log(`Backend tesr app listening on port ${port}`);
});

//eurekaHelper.registerWithEureka('app', port);
