import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
    apiKey: "AIzaSyBvVn4aRgXxCoIkyU-J1g_2cxHWlvrR2hE",
    authDomain: "code-differently-ics.firebaseapp.com",
    projectId: "code-differently-ics",
    storageBucket: "code-differently-ics.appspot.com",
    messagingSenderId: "363072609319",
    appId: "1:363072609319:web:6d27397be4a1334a3e8202"
};

export const app = initializeApp(firebaseConfig);
export const auth = getAuth();