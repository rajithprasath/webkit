import * as React from 'react';
import ToggleButton from '@mui/material/ToggleButton';
import ToggleButtonGroup from '@mui/material/ToggleButtonGroup';

const ColorToggleButton = () => {
  const [alignment, setAlignment] = React.useState('web');

  const handleChange = (event, newAlignment) => {
    setAlignment(newAlignment);
  };

  return (
    <ToggleButtonGroup
      color="primary"
      value={alignment}
      exclusive
      onChange={handleChange}
      aria-label="Platform"
    >
      <ToggleButton value="web">ALL</ToggleButton>
      <ToggleButton value="android">WORKING</ToggleButton>
      <ToggleButton value="ios">UNSUCCESSFULL</ToggleButton>
    </ToggleButtonGroup>
  );
}

export default ColorToggleButton
