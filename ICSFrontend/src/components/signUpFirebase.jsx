import { createUserWithEmailAndPassword } from "firebase/auth";
import { auth } from "../firebase";
//import Password from "./Password";

const signUpFireBase = async (email, password) => {
  try {
    const userCredential = await createUserWithEmailAndPassword(auth, email, password);

    const user = userCredential.user;
    return user;
  } catch (error) {
    const errorMessage = error.message;
    console.log(errorMessage);
    return null;
  }
};

export default signUpFireBase;