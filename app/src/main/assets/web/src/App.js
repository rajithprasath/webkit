import { Route, Routes } from 'react-router-dom';
import './App.css';
import ProminentAppBar from './components/ProminentAppBar';
import Submitted from './components/Submitted';
import BasicTabs from './components/BasicTabs';
import ReviewAndConfirm from './components/ReviewAndConfirm';
import Navigation from './components/Navigation';

const App = () => {
  return (
    <>
      <ProminentAppBar />
      <Routes>
        <Route path="/" element={<BasicTabs />} />
        <Route path="/review-confirm" element={<ReviewAndConfirm />} />
        <Route path="/submitted" element={<Submitted />} />
        <Route path="/navigation" element={<Navigation />} />
      </Routes>
    </>
  );
}

export default App;
