/* global Android */
import * as React from 'react';
import Grid from '@mui/material/Grid2';
import Button from '@mui/material/Button';

const Navigation = () => {

    const handleClick1 = () => {
        if (window.uob === undefined) {
            window.uob = {
                bridge: {
                    send(action, payload) {
                    console.debug("testing nav 33333", action, payload);
                    Android.navigateTo(payload.route, JSON.stringify(payload.params));

                    }
                }
            }
        }
        // 'Go to dashboard' button 
        window.uob.bridge.send('navigate', {route: 'dashboard', params: null})
    }

    const handleClick2 = () => {
        if (window.uob === undefined) {
            window.uob = {
                bridge: {
                    send(action, payload) {
                        console.debug("testing nav 2222 ", action, payload)
                    }
                }
            }
        }
        window.uob.bridge.send('navigate', {route: 'accounts', params: {category: 2}})
    }

    const handleClick3 = () => {
        if (window.uob === undefined) {
            window.uob = {
                bridge: {
                    send(action, payload) {
                        console.debug("testing nav 1111", action, payload)
                    }
                }
            }
        }
        window.uob.bridge.send('navigate', {route: 'rewards+', params: {category: 3}})
    }

    return (
    <>
        <Grid container spacing={2}>
            <Grid size={2}></Grid>
            <Grid style={{marginTop: '16px'}} size={8}>
                <Button onClick={handleClick1} variant="contained">
                    Button 1
                </Button>
            </Grid>
            <Grid size={2}></Grid>
            <Grid size={2}></Grid>
            <Grid size={8}>
                <Button onClick={handleClick2} variant="outlined">
                    Button 2
                </Button>
            </Grid>
            <Grid size={2}></Grid>
            <Grid size={2}></Grid>
            <Grid size={8}>
                <Button onClick={handleClick3} variant="text">
                    Button 3
                </Button>
            </Grid>
            <Grid size={2}></Grid>
        </Grid>
    </>
    );
}

export default Navigation;
