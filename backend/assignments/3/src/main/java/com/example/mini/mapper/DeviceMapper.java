package com.example.mini.mapper;

import com.example.mini.DTO.AddDeviceRequest;
import com.example.mini.DTO.DeviceRegisterRequest;

import com.example.mini.entity.Device;

import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {

    public static Device mapDeviceDTO(DeviceRegisterRequest deviceDTO) {
        Device device = new Device();
        device.setKickstonId(deviceDTO.getKickstonId());
        device.setDeviceUsername(deviceDTO.getDeviceUsername());
        device.setDevicePassword(deviceDTO.getDevicePassword());
        return device;
    }

}
