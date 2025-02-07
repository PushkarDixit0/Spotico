import './App.css';
import { ToastContainer } from 'react-toastify';
import LoginPage from './Pages/LoginPage/LoginPage';
import RegisterPage from './Pages/RegisterPage/RegisterPage';
import { Route, Routes } from 'react-router-dom';
import HomePage from './Pages/HomePage/HomePage';
import ViewEnrolledPage from './Pages/ViewEnrolledPage/ViewEnrolledPage';

function App() {
  return (
    <>
      <ToastContainer />
      <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/login' element={<LoginPage />} />
        <Route path='/register' element={<RegisterPage />} />
        <Route path='/enrollment' element={<ViewEnrolledPage/>} />
      </Routes>
    </>
  );
}

export default App;
