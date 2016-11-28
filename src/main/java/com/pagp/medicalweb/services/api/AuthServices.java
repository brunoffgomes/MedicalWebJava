package com.pagp.medicalweb.services.api;

import com.pagp.medicalweb.services.models.UserLoginServicesInDto;
import com.pagp.medicalweb.services.models.UserLoginServicesOutDto;

public interface AuthServices {

	UserLoginServicesOutDto login(UserLoginServicesInDto user);

}
