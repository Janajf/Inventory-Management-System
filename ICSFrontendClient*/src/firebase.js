// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyBvVn4aRgXxCoIkyU-J1g_2cxHWlvrR2hE",
  authDomain: "code-differently-ics.firebaseapp.com",
  projectId: "code-differently-ics",
  storageBucket: "code-differently-ics.appspot.com",
  messagingSenderId: "363072609319",
  appId: "1:363072609319:web:30c84c5d9e5c1cb83e8202",
  measurementId: "G-W4PYEVW3RG"
};

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);

export{app, auth};